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

    public void deleteCommonUser(String id) {
        if (commonUserRepository.existsById(id)){
            commonUserRepository.deleteById(id);
            return;
        }
        throw new ResourceNotFoundException(id);
    }

    public CommonUser updateCommonUser(String id, CommonUser newCommonUser) {
        Optional<CommonUser> commonUser = commonUserRepository.findById(id);
        if (commonUser.isPresent()){
            return updateData(commonUser.get(),newCommonUser);
        }
        throw new ResourceNotFoundException(id);
    }

    private CommonUser updateData(CommonUser commonUser, CommonUser newCommonUser) { // todo builder()
        commonUser.setEmail(newCommonUser.getEmail());
        commonUser.setBirthDate(newCommonUser.getBirthDate());
        commonUser.setIdAuth(newCommonUser.getIdAuth());
        commonUser.setName(newCommonUser.getName());
        commonUser.setPhone(newCommonUser.getPhone());
        return commonUserRepository.save(commonUser);
    }
}


