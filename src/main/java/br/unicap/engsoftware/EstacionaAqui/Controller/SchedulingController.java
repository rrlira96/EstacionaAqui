package br.unicap.engsoftware.EstacionaAqui.Controller;

import br.unicap.engsoftware.EstacionaAqui.Entities.Scheduling;
import br.unicap.engsoftware.EstacionaAqui.Service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/schedules")
public class SchedulingController {

    @Autowired
    private SchedulingService schedulingService;

    @GetMapping
    public ResponseEntity<List<Scheduling>> getAllSchedules() {
        return ResponseEntity.ok().body(schedulingService.getAllSchedules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scheduling> getSchedulesById(@PathVariable int id) {
        return ResponseEntity.ok().body(schedulingService.getSchedulesById(id));
    }

    @PostMapping
    public ResponseEntity<Scheduling> addScheduling(@Valid @RequestBody Scheduling obj) {
        Scheduling scheduling = schedulingService.createScheduling(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(scheduling.getId()).toUri();
        return ResponseEntity.created(uri).body(scheduling);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Scheduling> deleteScheduling(@PathVariable int id) {
        schedulingService.deleteScheduling(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scheduling> updateScheduling(@PathVariable int id, @RequestBody Scheduling scheduling) {
        return ResponseEntity.ok().body(schedulingService.updateScheduling(id, scheduling));
    }


}
