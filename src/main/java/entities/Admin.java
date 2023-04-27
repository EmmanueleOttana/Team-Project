package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Admin {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;
    private String role;
    private String authorizations;

    public Admin(long id, String username, String password, String role, String authorizations) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.authorizations = authorizations;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
