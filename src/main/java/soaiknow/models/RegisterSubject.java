package soaiknow.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by SimonaS on 17/03/2017.
 */

@Entity
public class RegisterSubject {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long serialNumber;
    private String subjectCode;
    private String subjectName;
    private String subjectProfessor;
    private boolean isConfirmed;
    private Date date;
    private boolean isPaid;
    private boolean isPassed;
    private String grade;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public RegisterSubject(Long serialNumber, String subjectCode, String subjectName, String subjectProfessor, boolean isConfirmed, Date date, boolean isPaid, boolean isPassed) {
        this.serialNumber = serialNumber;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.subjectProfessor = subjectProfessor;
        this.isConfirmed = isConfirmed;
        this.date = date;
        this.isPaid = isPaid;
        this.isPassed = isPassed;
        this.grade = "5";
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public Date getDate() {
        return date;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
