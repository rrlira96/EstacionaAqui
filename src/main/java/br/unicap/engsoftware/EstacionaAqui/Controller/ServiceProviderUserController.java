package br.unicap.engsoftware.EstacionaAqui.Controller;

import br.unicap.engsoftware.EstacionaAqui.Entities.CommonUser;
import br.unicap.engsoftware.EstacionaAqui.Entities.ServiceProviderUser;
import br.unicap.engsoftware.EstacionaAqui.Service.CommonUserService;
import br.unicap.engsoftware.EstacionaAqui.Service.ServiceProviderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/serviceProviderUsers")
public class ServiceProviderUserController {

    @Autowired
    private ServiceProviderUserService serviceProviderUserService;

    @GetMapping
    public ResponseEntity<List<ServiceProviderUser>> getAllServiceProviderUsers() {
        return ResponseEntity.ok().body(serviceProviderUserService.getAllServiceProviderUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderUser> getServiceProvideUserById(@PathVariable String id) {
        return ResponseEntity.ok().body(serviceProviderUserService.getServiceProviderUserById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceProviderUser> addServiceProviderUser(@RequestBody ServiceProviderUser obj) {
        ServiceProviderUser serviceProviderUser = serviceProviderUserService.createServiceProviderUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(serviceProviderUser.getCnpj()).toUri();
        return ResponseEntity.created(uri).body(serviceProviderUser);
    }

}
