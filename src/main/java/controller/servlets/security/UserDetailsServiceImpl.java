package main.java.controller.servlets.security;

import main.java.controller.dao.DAOException;
import main.java.controller.dao.FactoryDAO;
import main.java.controller.dao.UserDAO;
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
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserDAO dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getUserDAO();

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user;
        try {
            user = dao.get(login);
            if (user == null){
                throw new UsernameNotFoundException("User not found");
            }else{
                Set<GrantedAuthority> roles = new HashSet();
                roles.add(new SimpleGrantedAuthority("ROLE_USER"));
                UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                        user.getLogin(), user.getPassword(), true, true, true, true, roles);
                return userDetails;
            }
        }catch (DAOException e){
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}