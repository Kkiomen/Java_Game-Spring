package pl.kkiomen.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int x;
    private int y;
    private boolean isUserCity = false;
    private int woodCount = 0;
    private int stoneCount = 0;
    private int peopleCount = 0;
    private int moneyCount = 0;
    private int level = 0;


    public City() {
    }
}
