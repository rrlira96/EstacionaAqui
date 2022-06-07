package br.unicap.engsoftware.EstacionaAqui.Service;

import br.unicap.engsoftware.EstacionaAqui.Entities.Parking;
import br.unicap.engsoftware.EstacionaAqui.Repository.ParkingRepository;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.InvalidParkingSpotQuantityException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceAlreadyExistsException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public List<Parking> getAllParkingLots() {
        return parkingRepository.findAll();
    }

    public List<Parking> getAllParkingLotsByOwner(String ownerEmail) {
        return parkingRepository.findAllByOwnerEmail(ownerEmail);
    }


    public Parking getParkingById(int id) {
        Optional<Parking> parking = parkingRepository.findById(id);
        return parking.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public Parking createParking(Parking parking) {
        if (parking.getParkingSpotQuantity() <= parking.getTotalParkingSpot()) {
            if (!parkingRepository.existsById(parking.getId())) {
                return parkingRepository.save(parking);
            }
            throw new ResourceAlreadyExistsException(String.valueOf(parking.getId()));
        }
        throw new InvalidParkingSpotQuantityException();
    }

    public void deleteParking(int id) {
        if (parkingRepository.existsById(id)) {
            parkingRepository.deleteById(id);
            return;
        }
        throw new ResourceNotFoundException(String.valueOf(id));
    }

    public Parking updateParking(int id, Parking newParking) {
        Optional<Parking> parking = parkingRepository.findById(id);
        if (parking.isPresent()) {
            return updateData(parking.get(), newParking);
        }
        throw new ResourceNotFoundException(String.valueOf(id));
    }

    private Parking updateData(Parking parking, Parking newParking) {
        parking.setOwnerEmail(newParking.getOwnerEmail());
        parking.setCep(newParking.getCep());
        parking.setName(newParking.getName());
        parking.setParkingSpotQuantity(newParking.getParkingSpotQuantity());
        parking.setTotalParkingSpot(newParking.getTotalParkingSpot());
        parking.setPhone(newParking.getPhone());
        parking.setLatitude(newParking.getLatitude());
        parking.setLongitude(newParking.getLongitude());
        parking.setAddress(newParking.getAddress());
        return parkingRepository.save(parking);
    }
}
