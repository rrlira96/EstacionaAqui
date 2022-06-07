package br.unicap.engsoftware.EstacionaAqui.Controller;

import br.unicap.engsoftware.EstacionaAqui.Entities.Parking;
import br.unicap.engsoftware.EstacionaAqui.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/parkingLots")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping
    public ResponseEntity<List<Parking>> getAllParkingLots(@RequestParam Optional<String> ownerEmail) {
        return ResponseEntity.ok().body(ownerEmail.isPresent() ? parkingService.getAllParkingLotsByOwner(ownerEmail.get()) : parkingService.getAllParkingLots());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parking> getParkingById(@PathVariable int id) {
        return ResponseEntity.ok().body(parkingService.getParkingById(id));
    }

    @PostMapping
    public ResponseEntity<Parking> addParking(@Valid @RequestBody Parking obj) {
        Parking parking = parkingService.createParking(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(parking.getId()).toUri();
        return ResponseEntity.created(uri).body(parking);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Parking> deleteParking(@PathVariable int id) {
        parkingService.deleteParking(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Parking> updateParking(@PathVariable int id, @RequestBody Parking parking) {
        return ResponseEntity.ok().body(parkingService.updateParking(id, parking));
    }


}
