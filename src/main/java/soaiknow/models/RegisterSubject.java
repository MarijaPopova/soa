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

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private User user;

    public RegisterSubject(Long serialNumber, boolean isConfirmed, Date date, boolean areTaxesPaid) {
        this.serialNumber = serialNumber;
        this.isConfirmed = isConfirmed;
        this.date = date;
        this.areTaxesPaid = areTaxesPaid;
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
}
