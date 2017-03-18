package soaiknow.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 133003 on 3/7/2017.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;
    private String firstName;
    private String lastName;
    private String index;
    @OneToMany
    private List<RegisterSubject> registerSubjects;

    public Student() {
    }

    public Student(String firstName, String lastName, String index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.index = index;
        this.registerSubjects = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s', index='%s']",
                id, firstName, lastName, index);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
