package br.unicap.engsoftware.EstacionaAqui.Service;

import br.unicap.engsoftware.EstacionaAqui.Entities.Parking;
import br.unicap.engsoftware.EstacionaAqui.Entities.Scheduling;
import br.unicap.engsoftware.EstacionaAqui.Repository.ParkingRepository;
import br.unicap.engsoftware.EstacionaAqui.Repository.SchedulingRepository;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.FullParkingLotException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceAlreadyExistsException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    @Autowired
    private ParkingRepository parkingRepository;

    public List<Scheduling> getAllSchedules() {
        return schedulingRepository.findAll();
    }

    public List<Scheduling> getAllSchedulesByEmail(String email) {
        return schedulingRepository.findAllByEmail(email);
    }

    public Scheduling getSchedulesById(int id) {
        Optional<Scheduling> scheduling = schedulingRepository.findById(id);
        return scheduling.orElseThrow(() -> new ResourceNotFoundException(String.valueOf(id)));
    }

    public Scheduling createScheduling(Scheduling scheduling) {
        if (!schedulingRepository.existsById(scheduling.getId())) {
            Optional<Parking> parking = parkingRepository.findById(scheduling.getParking().getId());
            if (parking.isPresent()) {
                try {
                    parking.get().setParkingSpotQuantity(parking.get().getParkingSpotQuantity() - 1);
                    return schedulingRepository.save(scheduling);
                } catch (TransactionSystemException e) {
                    throw new FullParkingLotException();
                }
            }
            throw new ResourceNotFoundException(String.valueOf(scheduling.getParking().getId())); // todo
        }
        throw new ResourceAlreadyExistsException(String.valueOf(scheduling.getId()));
    }

    public void deleteScheduling(int id) {
        Optional<Scheduling> scheduling = schedulingRepository.findById(id);
        if (scheduling.isPresent()) {
            schedulingRepository.deleteById(id);
            freeParkingSpot(scheduling.get().getParking());
            return;
        }
        throw new ResourceNotFoundException(String.valueOf(id));
    }

    private void freeParkingSpot(Parking parking) {
        parking.setParkingSpotQuantity(parking.getParkingSpotQuantity() + 1);
        parkingRepository.save(parking);
    }

    public Scheduling updateScheduling(int id, Scheduling newScheduling) {
        Optional<Scheduling> scheduling = schedulingRepository.findById(id);
        if (scheduling.isPresent()) {
            return updateData(scheduling.get(), newScheduling);
        }
        throw new ResourceNotFoundException(String.valueOf(id));
    }

    private Scheduling updateData(Scheduling scheduling, Scheduling newScheduling) {
        scheduling.setEmail(newScheduling.getEmail());
        scheduling.setParking(newScheduling.getParking());
        scheduling.setBookingDate(newScheduling.getBookingDate());
        return schedulingRepository.save(scheduling);
    }
}
