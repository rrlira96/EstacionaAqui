package br.unicap.engsoftware.EstacionaAqui.Repository;

import br.unicap.engsoftware.EstacionaAqui.Entities.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {

    @Query(value = "SELECT * FROM scheduling WHERE email = ?1", nativeQuery = true)
    List<Scheduling> findAllByEmail(String email);

}
