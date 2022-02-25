package pl.kkiomen.game.generator.map.Chunks.Helper;

import lombok.Getter;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Chunk;
import pl.kkiomen.game.model.City;

@Getter
@Setter
public class ChunkRender {
    private Chunk chunk;
    private City city;
}
