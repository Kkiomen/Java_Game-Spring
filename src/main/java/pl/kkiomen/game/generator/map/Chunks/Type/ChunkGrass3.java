package pl.kkiomen.game.generator.map.Chunks.Type;

import lombok.AccessLevel;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Chunk;
import pl.kkiomen.game.generator.map.Chunks.ChunkInterfece;
import pl.kkiomen.game.generator.map.Chunks.Enum.BiomeType;
import pl.kkiomen.game.generator.map.Chunks.Enum.ChunkType;

public class ChunkGrass3 extends Chunk implements ChunkInterfece {

    @Setter(AccessLevel.NONE)
    private ChunkType type = ChunkType.GRASS;
    private BiomeType biome = BiomeType.GRASS;
    private double speed = 2.2;
    private String urlImageChunk = "https://i.imgur.com/dMThVp9.png";
    public String name = "grass3";
    private int numberOfChunk = 3;

    public ChunkGrass3(int x, int y) {
        super(x, y);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUrlImageChunk() {
        return urlImageChunk;
    }

    @Override
    public BiomeType getBiome() {
        return biome;
    }

    @Override
    public int getTypeChunk(){
        return numberOfChunk;
    }
}
