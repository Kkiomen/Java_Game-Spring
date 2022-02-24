package pl.kkiomen.game.generator.map.Chunks;


import lombok.Getter;
import lombok.Setter;
import pl.kkiomen.game.generator.map.Chunks.Enum.BiomeType;

@Getter
@Setter
public class Chunk{
    protected int x;
    protected int y;
    public String color = "";
    public String name = "";
    private String urlImageChunk = "";
    private BiomeType biome = null;

    public Chunk(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String showCoordinates(){
        return "y: " + this.getY() + " x: " + this.getX();
    }

    public String getName() {
        return name;
    }

    public String getUrlImageChunk() {
        return urlImageChunk;
    }

    public BiomeType getBiome() {
        return biome;
    }
}
