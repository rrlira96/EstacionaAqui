package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    public Scheduling() {
    }

    public Scheduling(int id, String email, Parking parking) {
        this.id = id;
        this.email = email;
        this.parking = parking;
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
}
