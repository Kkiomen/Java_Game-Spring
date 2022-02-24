package pl.kkiomen.game.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kkiomen.game.model.User;

@NoArgsConstructor
@Getter
@Setter
public class CityDto {
    private Long id;
    private int x;
    private int y;
    private int woodCount = 0;
    private int stoneCount = 0;
    private int peopleCount = 0;
    private int moneyCount = 0;
    private int level = 0;
    private User user;

    public CityDto(Long id, int x, int y, int woodCount, int stoneCount, int peopleCount, int moneyCount, int level, User user) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.woodCount = woodCount;
        this.stoneCount = stoneCount;
        this.peopleCount = peopleCount;
        this.moneyCount = moneyCount;
        this.level = level;
        this.user = user;
    }
}
