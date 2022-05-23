package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "usuario_comum")
public class CommonUser extends User {

    @Id
    @Column(name = "Cpf")
    private String cpf;

    public CommonUser(){
    }

    public CommonUser(String name, Date birthDate, String email, String phone, String idAuth, String cpf) {
        super(name, birthDate, email, phone, idAuth);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
