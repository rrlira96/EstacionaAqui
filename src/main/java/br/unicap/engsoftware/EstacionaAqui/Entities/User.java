package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class User {

    @Column(name = "Nome")
    private String name;

    @Column(name = "DataNascimento")
    private Date birthDate;

    @Column(name = "Email")
    private String email;

    @Column(name = "Telefone")
    private String phone;

    @Column(name = "IdAuth")
    private String idAuth;

    public User() {
    }

    public User(String name, Date birthDate, String email, String phone, String idAuth) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.idAuth = idAuth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdAuth() {
        return idAuth;
    }

    public void setIdAuth(String idAuth) {
        this.idAuth = idAuth;
    }
}
