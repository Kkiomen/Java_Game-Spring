package pl.kkiomen.game.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kkiomen.game.model.City;


@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String email;
    private City city;


    public UserDto(Long id, String name, String password, String email, City city) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.city = city;
    }
}
