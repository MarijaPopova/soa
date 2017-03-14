package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by 133003 on 3/7/2017.
 */
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String code;
    private String nameSubject;
    private String description;
    private String profesor;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }


}
