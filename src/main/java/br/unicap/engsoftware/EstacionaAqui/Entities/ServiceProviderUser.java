package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "prestador_servico")
public class ServiceProviderUser extends User {

    @Id
    @Column(name = "Cnpj")
    private String cnpj;

    public ServiceProviderUser() {
    }

    public ServiceProviderUser(String name, Date birthDate, String email, String phone, String idAuth, String cnpj) {
        super(name, birthDate, email, phone, idAuth);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
