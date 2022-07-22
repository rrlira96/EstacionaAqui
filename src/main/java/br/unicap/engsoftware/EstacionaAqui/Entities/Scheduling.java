package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "scheduling")
public class Scheduling {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @NotNull
    private String email;

    @JoinColumn(name = "parking_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parking parking;

    @Column(name = "scheduling_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date schedulingDate;

    public Scheduling() {
    }

    public Scheduling(int id, String email, Parking parking, Date schedulingDate) {
        this.id = id;
        this.email = email;
        this.parking = parking;
        this.schedulingDate = schedulingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Parking getParking() {
        return parking;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Date getSchedulingDate() {
        return schedulingDate;
    }

    public void setSchedulingDate(Date schedulingDate) {
        this.schedulingDate = schedulingDate;
    }
}
