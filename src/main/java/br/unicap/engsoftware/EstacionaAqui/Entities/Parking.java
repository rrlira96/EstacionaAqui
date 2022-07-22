package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "zip_code")
    @NotNull
    private String zipCode;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "available_parking_spots")
    @Min(value = 0, message = "Parking spot quantity must not be less than 0")
    private int availableParkingSpots;

    @Column(name = "parking_spot_quantity")
    @Min(value = 0, message = "Total parking spot quantity must not be less than 0")
    private int totalParkingSpot;

    @Column(name = "phone")
    private String phone;

    @Column(name = "owner_email")
    @NotNull
    private String ownerEmail;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "address")
    private String address;


    public Parking() {
    }

    public Parking(int id, String zipCode, String name, int availableParkingSpots, int totalParkingSpot, String phone, String ownerEmail, String latitude, String longitude, String address) {
        this.id = id;
        this.zipCode = zipCode;
        this.name = name;
        this.availableParkingSpots = availableParkingSpots;
        this.totalParkingSpot = totalParkingSpot;
        this.phone = phone;
        this.ownerEmail = ownerEmail;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableParkingSpots() {
        return availableParkingSpots;
    }

    public void setAvailableParkingSpots(int availableParkingSpots) {
        this.availableParkingSpots = availableParkingSpots;
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

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String owner_email) {
        this.ownerEmail = owner_email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
