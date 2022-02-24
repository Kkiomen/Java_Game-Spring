package pl.kkiomen.game.generator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kkiomen.game.dto.CityDto;
import pl.kkiomen.game.dto.UserDto;
import pl.kkiomen.game.model.City;
import pl.kkiomen.game.model.User;
import pl.kkiomen.game.service.CityService;
import pl.kkiomen.game.service.UserService;

@Service
public class Generator {


    private static UserService userService;
    private static CityService cityService;

    public Generator(UserService userService, CityService cityService) {
        this.userService = userService;
        this.cityService = cityService;
    }

    public static void init(){
        //MapGenerator.generate();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("admin");
        UserDto userDto = new UserDto();
        userDto.setEmail("kuba.owsianka@interia.pl");
        userDto.setUsername("Kkiomen");
        userDto.setPassword(encodedPassword);
        userService.save(userDto);

        User user = userService.getEntityById(1L);
        CityDto cityDto = new CityDto();
        cityDto.setX(3);
        cityDto.setY(6);
        cityDto.setLevel(1);
        cityDto.setMoneyCount(0);
        cityDto.setPeopleCount(3);
        cityDto.setStoneCount(100);
        cityDto.setWoodCount(100);
        cityDto.setUser(user);
        cityService.save(cityDto);
    }


}
