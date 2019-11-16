package hu.cs.se.model;
import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Column(name = "user_id")
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNo;
    private String username;
    private String password;

//    private String roles ="";
////    private String permissions ="";
    private Set<Role> roles;
    private Set<Permission> permissions;

    @Column(unique = true)
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



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

//    public String getRoles() {
//        return roles;
//    }
//
//    public void setRoles(String roles) {
//        this.roles = roles;
//    }
//
//    public String getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(String permissions) {
//        this.permissions = permissions;
//    }

    @ManyToMany(fetch =FetchType.EAGER)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @ManyToMany(fetch =FetchType.EAGER)
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
