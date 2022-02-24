package pl.kkiomen.game.generator.map.Chunks.Type;

import lombok.AccessLevel;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Chunk;
import pl.kkiomen.game.generator.map.Chunks.ChunkInterfece;
import pl.kkiomen.game.generator.map.Chunks.Enum.BiomeType;
import pl.kkiomen.game.generator.map.Chunks.Enum.ChunkType;

public class ChunkDesert1 extends Chunk implements ChunkInterfece {

    @Setter(AccessLevel.NONE)
    private ChunkType type = ChunkType.DESERT;
    private BiomeType biome = BiomeType.DESERT;
    private double speed = 3;
    private String urlImageChunk = "https://i.imgur.com/ki6IwzH.png";
    public String name = "desert1";
    private int numberOfChunk = 10;

    public ChunkDesert1(int x, int y) {
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
