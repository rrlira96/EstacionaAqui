package br.unicap.engsoftware.EstacionaAqui.Repository;

import br.unicap.engsoftware.EstacionaAqui.Entities.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {
}
