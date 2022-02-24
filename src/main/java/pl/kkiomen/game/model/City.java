package pl.kkiomen.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int x;
    private int y;
    private int woodCount = 0;
    private int stoneCount = 0;
    private int peopleCount = 0;
    private int moneyCount = 0;
    private int level = 0;
    @OneToOne(mappedBy = "city")
    private User user;

    public City() {
    }
}
