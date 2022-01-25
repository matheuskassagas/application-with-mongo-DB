package applicationwithmongoDB.service;

import applicationwithmongoDB.DTO.UserDTO;
import applicationwithmongoDB.entity.User;
import applicationwithmongoDB.repositoryMongoBD.UserRepository;
import applicationwithmongoDB.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User create (User entity){
        return userRepository.save(entity);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update (User user){
        User newObj = findById(user.getId());
        updateData(newObj, user);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User user) {
        newObj.setName(user.getName());
        newObj.setEmail(user.getEmail());
    }

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }
}
