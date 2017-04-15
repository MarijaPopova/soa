package soaiknow.models;

/**
 * Created by Popov on 11.4.2017.
 */
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String embg;
    private String email;
    @Transient
    private String passwordConfirm;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    private List<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_semesters", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "semester_id"))
    private List<Semester> semesters;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_register", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "register_id"))
    private List<RegisterSubject> registerSubjects;

    public Long getId() {
        return id;
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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalinfo() {
        return String.format("Name is: %s/t EMBG: %s/t %s",fullName,embg,email);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    public List<RegisterSubject> getRegisterSubjects() {
        return registerSubjects;
    }

    public void setRegisterSubjects(List<RegisterSubject> registerSubjects) {
        this.registerSubjects = registerSubjects;
    }
}
