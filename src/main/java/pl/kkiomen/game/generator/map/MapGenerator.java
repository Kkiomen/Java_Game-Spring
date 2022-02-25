package pl.kkiomen.game.generator.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kkiomen.game.generator.map.Chunks.Enum.BiomeType;
import pl.kkiomen.game.generator.map.Chunks.Chunk;
import pl.kkiomen.game.generator.map.Chunks.Type.*;
import pl.kkiomen.game.generator.map.Chunks.Helper.Column;
import pl.kkiomen.game.service.MapChunkService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class MapGenerator {

    private static MapChunkService mapChunkService;

    public static final int SIZE_MAP = 12;
    private static Random random = new Random();

    @Autowired
    public MapGenerator(MapChunkService mapChunkService) {
        this.mapChunkService = mapChunkService;
    }

    public static ArrayList<Column> render() {
        ArrayList<Column> result = mapChunkService.getChunksToRenderMap(SIZE_MAP);
        return result;
    }

    public static ArrayList<Column> generate() {
        ArrayList<Column> result = new ArrayList<>(SIZE_MAP);
        for (int i = 0; i < SIZE_MAP; i++) {
            ArrayList<Chunk> chunks = new ArrayList<>(SIZE_MAP);
            for (int j = 0; j < SIZE_MAP; j++) {
                Chunk choosedChunk = chooseChunk(j, i, chunks, result);
                chunks.add(choosedChunk);
                mapChunkService.addChunk(choosedChunk);
            }
            result.add(new Column(chunks,null));
        }
        return result;
    }


    private static Chunk chooseChunk(int x, int y, ArrayList<Chunk> rows, ArrayList<Column> column) {
        if (x == 0 && y == 0) {
            return getRandomChunk(x, y);
        } else if (y == 0) {
            Chunk chunkOnLeft = getChunkOnLeft(x, rows);
            return getRandomChunkByNeighborOnLeft(chunkOnLeft, x, y);
        } else if (y != 0 && x != 0) {
            Chunk chunkOnLeft = getChunkOnLeft(x, rows);
            Chunk chunkOnTop = getChunkOnTop(x, y, column);
            return getRandomChunkByNeighborOnLeftAndTop(chunkOnLeft, chunkOnTop, x, y);
        }
        return new ChunkGrass(x, y);
    }

    private static Chunk getRandomChunkByNeighborOnLeftAndTop(Chunk chunkOnLeft, Chunk chunkOnTop, int x, int y) {
        BiomeType biomeLeft = chunkOnLeft.getBiome();
        BiomeType biomeTop = chunkOnTop.getBiome();

        if (biomeLeft == biomeTop) {
            List<Chunk> chunks = getAllChunkByBiome(x, y, biomeLeft);
            int index = 0;
            for (Chunk chunk : chunks) {
                if (chunk.getName().equals(chunkOnLeft.getName())) {
                    break;
                }
                index++;
            }

            double chance = random.nextDouble();
            if (chance < 0.4) {
                return chunks.get(index);
            } else if (chance < 0.5) {
                Collections.shuffle(chunks);
                return chunks.get(random.nextInt(chunks.size()));
            }
        }
        return getRandomChunk(x, y);
    }


    private static Chunk getRandomChunkByNeighborOnLeft(Chunk chunkOnLeft, int x, int y) {
        BiomeType biome = chunkOnLeft.getBiome();
        List<Chunk> chunks = getAllChunkByBiome(x, y, biome);
        int index = 0;
        for (Chunk chunk : chunks) {
            if (chunk.getName().equals(chunkOnLeft.getName())) {
                break;
            }
            index++;
        }

        double chance = random.nextDouble();
        if (chance < 0.4) {
            return chunks.get(index);
        } else if (chance < 0.5) {
            Collections.shuffle(chunks);
            return chunks.get(random.nextInt(chunks.size()));
        }

        return new ChunkGrass(x, y);
    }


    private static Chunk getChunkOnLeft(int x, ArrayList<Chunk> rows) {
        Chunk resultChunk = rows.get(x - 1);
        return resultChunk;
    }

    private static Chunk getChunkOnTop(int x, int y, ArrayList<Column> columns) {
        if (y != 0) {
            ArrayList<Chunk> rows = columns.get(y - 1).getChunksList();
            Chunk resultChunk = rows.get(x);
            return resultChunk;
        }
        return null;
    }

    private static BiomeType getRandomBiome() {
        double chance = random.nextDouble();
        if (chance < 0.1) {
            return BiomeType.WATER;
        } else if (chance < 0.15) {
            return BiomeType.DESERT;
        } else if (chance < 0.16) {
            return BiomeType.MOUNTAIN;
        } else if (chance < 0.17) {
            return BiomeType.MARCHES;
        }
        return BiomeType.GRASS;
    }

    private static Chunk getRandomChunk(int x, int y) {
        BiomeType randomBiome = getRandomBiome();
        return getRandomChunkFromBiome(randomBiome, x, y);
    }


    private static Chunk getRandomChunkFromBiome(BiomeType biome, int x, int y) {
        List<Chunk> list = new ArrayList<Chunk>();
        list = getAllChunkByBiome(x, y, biome);
        Collections.shuffle(list);
        return list.get(0);
    }

    private static List<Chunk> getAllChunkByBiome(int x, int y, BiomeType biome) {
        List<Chunk> list = new ArrayList<Chunk>();
        if (biome == BiomeType.GRASS) {
            list.add(new ChunkGrass(x, y));
            list.add(new ChunkGrass2(x, y));
            list.add(new ChunkGrass3(x, y));
        } else if (biome == BiomeType.DESERT) {
            list.add(new ChunkDesert1(x, y));
            list.add(new ChunkDesert2(x, y));
        } else if (biome == BiomeType.WATER) {
            list.add(new ChunkWater1(x, y));
            list.add(new ChunkWater2(x, y));
        } else if (biome == BiomeType.MOUNTAIN) {
            list.add(new ChunkMountain1(x, y));
            list.add(new ChunkMountain2(x, y));
            list.add(new ChunkMountain3(x, y));
        } else if (biome == BiomeType.MARCHES) {
            list.add(new ChunkMarches1(x, y));
        }
        return list;
    }


//    private static Chunk randomChunkWithChance(int x, int y){
//        double chance = random.nextDouble();
//        if(chance < 0.1){
//            return new Chunk
//        }
//    }

}
