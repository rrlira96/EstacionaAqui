package br.unicap.engsoftware.EstacionaAqui.Service;

import br.unicap.engsoftware.EstacionaAqui.Entities.ServiceProviderUser;
import br.unicap.engsoftware.EstacionaAqui.Repository.ServiceProviderUserRepository;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceAlreadyExistsException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderUserService {

    @Autowired
    private ServiceProviderUserRepository serviceProviderUserRepository;

    public List<ServiceProviderUser> getAllServiceProviderUsers() {
        return serviceProviderUserRepository.findAll();
    }

    public ServiceProviderUser getServiceProviderUserById(String id) {
        Optional<ServiceProviderUser> serviceProviderUser = serviceProviderUserRepository.findById(id);
        return serviceProviderUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public ServiceProviderUser createServiceProviderUser(ServiceProviderUser serviceProviderUser) {
        if (!serviceProviderUserRepository.existsById(serviceProviderUser.getCnpj())) {
            return serviceProviderUserRepository.save(serviceProviderUser);
        }
        throw new ResourceAlreadyExistsException(serviceProviderUser.getCnpj());
    }

    public void deleteServiceProviderUser(String id) {
        if (serviceProviderUserRepository.existsById(id)) {
            serviceProviderUserRepository.deleteById(id);
            return;
        }
        throw new ResourceNotFoundException(id);
    }

    public ServiceProviderUser updateServiceProviderUser(String id, ServiceProviderUser newServiceProviderUser) {
        Optional<ServiceProviderUser> serviceProviderUser = serviceProviderUserRepository.findById(id);
        if (serviceProviderUser.isPresent()) {
            return updateData(serviceProviderUser.get(), newServiceProviderUser);
        }
        throw new ResourceNotFoundException(id);
    }

    private ServiceProviderUser updateData(ServiceProviderUser serviceProviderUser, ServiceProviderUser newServiceProviderUser) { // todo builder()
        serviceProviderUser.setBirthDate(newServiceProviderUser.getBirthDate());
        serviceProviderUser.setEmail(newServiceProviderUser.getEmail());
        serviceProviderUser.setIdAuth(newServiceProviderUser.getIdAuth());
        serviceProviderUser.setName(newServiceProviderUser.getName());
        serviceProviderUser.setPhone(newServiceProviderUser.getPhone());
        return serviceProviderUserRepository.save(serviceProviderUser);
    }

}


