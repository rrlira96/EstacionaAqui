package br.unicap.engsoftware.EstacionaAqui.Controller;

import br.unicap.engsoftware.EstacionaAqui.Entities.CommonUser;
import br.unicap.engsoftware.EstacionaAqui.Service.CommonUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/commonUsers")
public class CommonUserController {

    @Autowired
    private CommonUserService commonUserService;

    @GetMapping
    public ResponseEntity<List<CommonUser>> getAllCommonUsers() {
        return ResponseEntity.ok().body(commonUserService.getAllCommonUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonUser> getCommonUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(commonUserService.getCommonUserById(id));
    }

    @PostMapping
    public ResponseEntity<CommonUser> addCommonUser(@RequestBody CommonUser obj) {
        CommonUser commonUser = commonUserService.createCommonUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(commonUser.getCpf()).toUri();
        return ResponseEntity.created(uri).body(commonUser);
    }

}
