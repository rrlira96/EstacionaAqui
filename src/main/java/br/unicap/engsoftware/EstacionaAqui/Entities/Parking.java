package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.*;

@Entity
@Table(name = "estacionamento")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "Cep")
    private String cep;

    @Column(name = "Nome")
    private String name;

    @Column(name = "QtdVagasDisponiveis")
    private int parkingSpotQuantity;

    @Column(name = "QtdVagasTotal")
    private int totalParkingSpot;

    @Column(name = "Telefone")
    private String phone;

    @ManyToOne
    private ServiceProviderUser serviceProviderUser;

    public Parking() {
    }

    public Parking(int id, String cep, String name, int parkingSpotQuantity, int totalParkingSpot, String phone, ServiceProviderUser serviceProviderUser) {
        this.id = id;
        this.cep = cep;
        this.name = name;
        this.parkingSpotQuantity = parkingSpotQuantity;
        this.totalParkingSpot = totalParkingSpot;
        this.phone = phone;
        this.serviceProviderUser = serviceProviderUser;
    }

    public ServiceProviderUser getServiceProviderUser() {
        return serviceProviderUser;
    }

    public void setServiceProviderUser(ServiceProviderUser serviceProviderUser) {
        this.serviceProviderUser = serviceProviderUser;
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

}
