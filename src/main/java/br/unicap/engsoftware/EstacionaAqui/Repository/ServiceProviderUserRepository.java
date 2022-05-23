package br.unicap.engsoftware.EstacionaAqui.Repository;

import br.unicap.engsoftware.EstacionaAqui.Entities.ServiceProviderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProviderUserRepository extends JpaRepository<ServiceProviderUser, String> {
}
