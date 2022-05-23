package br.unicap.engsoftware.EstacionaAqui.Repository;

import br.unicap.engsoftware.EstacionaAqui.Entities.CommonUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonUserRepository extends JpaRepository<CommonUser, String> {
}
