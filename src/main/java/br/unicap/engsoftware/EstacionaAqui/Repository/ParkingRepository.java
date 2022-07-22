package br.unicap.engsoftware.EstacionaAqui.Repository;

import br.unicap.engsoftware.EstacionaAqui.Entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

    @Query(value = "SELECT * FROM parking WHERE owner_email = ?1", nativeQuery = true)
    List<Parking> findAllByOwnerEmail(String ownerEmail);
}
