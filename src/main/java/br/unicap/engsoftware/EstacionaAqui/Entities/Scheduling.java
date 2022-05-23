package br.unicap.engsoftware.EstacionaAqui.Entities;

import javax.persistence.*;

@Entity
@Table(name = "agendamento")
public class Scheduling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;


    @JoinColumn(name = "UsuarioComumCpf", referencedColumnName = "Cpf", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CommonUser commonUser;

    @JoinColumn(name = "CnpjPrestadorServico", referencedColumnName = "Cnpj", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ServiceProviderUser serviceProviderUser;

    public Scheduling() {
    }

    public Scheduling(int id, CommonUser commonUser, ServiceProviderUser serviceProviderUser) {
        this.id = id;
        this.commonUser = commonUser;
        this.serviceProviderUser = serviceProviderUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CommonUser getCommonUser() {
        return commonUser;
    }

    public void setCommonUser(CommonUser commonUser) {
        this.commonUser = commonUser;
    }

    public ServiceProviderUser getServiceProviderUser() {
        return serviceProviderUser;
    }

    public void setServiceProviderUser(ServiceProviderUser serviceProviderUser) {
        this.serviceProviderUser = serviceProviderUser;
    }
}
