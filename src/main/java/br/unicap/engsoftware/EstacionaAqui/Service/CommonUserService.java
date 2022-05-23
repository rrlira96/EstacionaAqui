package br.unicap.engsoftware.EstacionaAqui.Service;

import br.unicap.engsoftware.EstacionaAqui.Entities.CommonUser;
import br.unicap.engsoftware.EstacionaAqui.Repository.CommonUserRepository;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceAlreadyExistsException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommonUserService {

    @Autowired
    private CommonUserRepository commonUserRepository;

    public List<CommonUser> getAllCommonUsers() {
        return commonUserRepository.findAll();
    }

    public CommonUser getCommonUserById(String id) {
        Optional<CommonUser> commonUser = commonUserRepository.findById(id);
        return commonUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public CommonUser createCommonUser(CommonUser commonUser) {
        if (!commonUserRepository.existsById(commonUser.getCpf())){
            return commonUserRepository.save(commonUser);
        }
        throw new ResourceAlreadyExistsException(commonUser.getCpf());
    }
}


