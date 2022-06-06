package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "agendamento")
public class Scheduling {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @NotNull
    private String email;

    @JoinColumn(name = "id_estacionamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parking parking;

    @Column(name = "data_reserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;

    public Scheduling() {
    }

    public Scheduling(int id, String email, Parking parking, Date bookingDate) {
        this.id = id;
        this.email = email;
        this.parking = parking;
        this.bookingDate = bookingDate;
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
