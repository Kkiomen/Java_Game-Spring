package pl.kkiomen.game.generator.map.Chunks.Helper;

import lombok.Getter;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Chunk;

import java.util.ArrayList;

@Getter
@Setter
public class Row {
    public ArrayList<Chunk> chunksX = new ArrayList<>();
}
