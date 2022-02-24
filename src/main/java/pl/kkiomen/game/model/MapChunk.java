package pl.kkiomen.game.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Chunk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class MapChunk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int x;
    private int y;
    private int typeChunk;

    public MapChunk(int x, int y, int typeChunk) {
        this.x = x;
        this.y = y;
        this.typeChunk = typeChunk;
    }
}
