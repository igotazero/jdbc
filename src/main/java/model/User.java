package main.java.model;

public class User {
    private String login;
    private String password;
    private String name;
    private String address;

    public User(){}

    public User(String login, String password, String name, String address) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return login + " | " + password + " | " + name + " | " + address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (this == obj){
            return true;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        User user = (User)obj;
        if (!login.equals(user.login)){
            return false;
        }
        if (!password.equals(user.password)){
            return false;
        }
        if (!name.equals(user.name)){
            return false;
        }
        if (!address.equals(user.address)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return login.length() * password.length()
                * name.length() * address.length() *  777;
    }
}
