package soaiknow.models;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String name;
    private String description;
    private String professor;
    private boolean isPassed;
    private String grade;
    private boolean hasSignature;

    @OneToMany(cascade = CascadeType.ALL)
    private List<RegisterSubject> registered;

    public Subject(){}

    public Subject(String code, String name, String description, String professor){
        this.code = code;
        this.description = description;
        this.name = name;
        this.professor = professor;
        isPassed = false;
        grade = "5";
        registered = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
        int g = Integer.parseInt(grade);
        if(g > 5 && g < 10){
            isPassed = true;
        }
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public boolean isHasSignature() {
        return hasSignature;
    }

    public void setHasSignature(boolean hasSignature) {
        this.hasSignature = hasSignature;
    }

    public void addRegistered(RegisterSubject subject){
        registered.add(subject);
    }
}
