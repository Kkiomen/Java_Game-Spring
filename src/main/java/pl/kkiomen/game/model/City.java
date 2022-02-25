package pl.kkiomen.game.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

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
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    public City() {
    }

    public boolean isOwner(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        if(currentPrincipalName.equals(this.getUser().getUsername())){
            return true;
        }else{
            return false;
        }
    }
}
