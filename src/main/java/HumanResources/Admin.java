package HumanResources;

public class Admin {

    public String username;
    public String password;
    public String role;
    public String authorizations;

    public Admin(String username, String password, String role, String authorizations) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorizations = authorizations;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(String authorizations) {
        this.authorizations = authorizations;
    }

}
