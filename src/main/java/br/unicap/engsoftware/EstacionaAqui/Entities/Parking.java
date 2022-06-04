package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estacionamento")
public class Parking {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "cep")
    @NotNull
    private String cep;

    @Column(name = "nome")
    @NotNull
    private String name;

    @Column(name = "qtd_vagas_disponiveis")
    @Min(value = 0, message = "Parking spot quantity must not be less than 0")
    private int parkingSpotQuantity;

    @Column(name = "qtd_vagas_total")
    @Min(value = 0, message = "Total parking spot quantity must not be less than 0")
    private int totalParkingSpot;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "email")
    @NotNull
    private String email;

    public Parking() {
    }

    public Parking(int id, String cep, String name, int parkingSpotQuantity, int totalParkingSpot, String phone, String email) {
        this.id = id;
        this.cep = cep;
        this.name = name;
        this.parkingSpotQuantity = parkingSpotQuantity;
        this.totalParkingSpot = totalParkingSpot;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParkingSpotQuantity() {
        return parkingSpotQuantity;
    }

    public void setParkingSpotQuantity(int parkingSpotQuantity) {
        this.parkingSpotQuantity = parkingSpotQuantity;
    }

    public int getTotalParkingSpot() {
        return totalParkingSpot;
    }

    public void setTotalParkingSpot(int totalParkingSpot) {
        this.totalParkingSpot = totalParkingSpot;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
