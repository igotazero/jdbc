package main.java.controller.servlets.security;

import main.java.controller.servlets.services.UserService;
import main.java.model.User;
import main.java.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Andrei_Zanozin on 7/20/2016.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUser(login);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserRole.USER.name()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(), roles);
        return userDetails;
    }
}