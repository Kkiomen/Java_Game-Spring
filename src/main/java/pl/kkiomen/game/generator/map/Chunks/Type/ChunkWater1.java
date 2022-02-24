package pl.kkiomen.game.generator.map.Chunks.Type;

import lombok.AccessLevel;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Chunk;
import pl.kkiomen.game.generator.map.Chunks.ChunkInterfece;
import pl.kkiomen.game.generator.map.Chunks.Enum.BiomeType;
import pl.kkiomen.game.generator.map.Chunks.Enum.ChunkType;

public class ChunkWater1 extends Chunk implements ChunkInterfece {

    @Setter(AccessLevel.NONE)
    private ChunkType type = ChunkType.WATER;
    private BiomeType biome = BiomeType.WATER;
    private double speed = 6;
    private String urlImageChunk = "https://i.imgur.com/JBMfACw.png";
    public String name = "water1";
    private int numberOfChunk = 8;

    public ChunkWater1(int x, int y) {
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
