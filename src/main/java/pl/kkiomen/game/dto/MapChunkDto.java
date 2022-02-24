package pl.kkiomen.game.dto;

import lombok.Getter;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Chunk;

@Getter
@Setter
public class MapChunkDto {
    private Long id;
    private int x;
    private int y;
    private int typeChunk;
    private Chunk chunk;
}
