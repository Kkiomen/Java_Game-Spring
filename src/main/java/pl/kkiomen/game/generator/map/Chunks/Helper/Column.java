package pl.kkiomen.game.generator.map.Chunks.Helper;

import lombok.Getter;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Chunk;

import java.util.ArrayList;

@Getter
@Setter
public class Column {
    public ArrayList<Chunk> chunksList = new ArrayList<>();
    public ArrayList<ChunkRender> chunkRenders = new ArrayList<>();
    public Column(ArrayList<Chunk> chunksList, ArrayList<ChunkRender> chunkRenders) {
        this.chunksList = chunksList;
        this.chunkRenders = chunkRenders;
    }
}
