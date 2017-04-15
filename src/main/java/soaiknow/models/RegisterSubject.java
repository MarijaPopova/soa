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
    private boolean isConfirmed;
    private Date date;
    private boolean areTaxesPaid;
    private String examSession;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private User user;

    public RegisterSubject(){
        isConfirmed = false;
        areTaxesPaid = false;
        date = new Date();
    }

    public RegisterSubject(Long serialNumber, boolean isConfirmed, Date date, boolean areTaxesPaid, String examSession) {
        this.serialNumber = serialNumber;
        this.isConfirmed = isConfirmed;
        this.date = date;
        this.areTaxesPaid = areTaxesPaid;
        this.examSession = examSession;
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

    public boolean isAreTaxesPaid() {
        return areTaxesPaid;
    }

    public String getExamSession() {
        return examSession;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setExamSession(String examSession) {
        this.examSession = examSession;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getUser() {
        return user;
    }
}
