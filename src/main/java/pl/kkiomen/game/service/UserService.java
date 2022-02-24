package pl.kkiomen.game.service;

import org.springframework.stereotype.Service;
import pl.kkiomen.game.dto.UserDto;
import pl.kkiomen.game.exception.NotFoundUser;
import pl.kkiomen.game.model.User;
import pl.kkiomen.game.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean save(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setCity(userDto.getCity());
        userRepository.save(user);
        return true;
    }

    public User getEntityById(Long Id){
        Optional<User> optional = userRepository.findById(Id);
        return optional.orElseGet(() -> userRepository.findById(Id).orElseThrow(NotFoundUser::new));
    }

    public UserDto getById(Long id){
        User user = getEntityById(id);
        if(user != null){
            return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getCity()
            );
        }
        return null;
    }

    public void update(UserDto userDto){
        User user = getEntityById(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCity(userDto.getCity());
        userRepository.save(user);
    }

    public void delete(Long id) {
        User user = getEntityById(id);
        userRepository.delete(user);
    }

    public List<User> getAll(){
        List<User> user = new ArrayList<>();
        userRepository.findAll().forEach(user::add);
        return user;
    }

    public User findByUsername(String username){
        List<User> users = getAll();
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

}
