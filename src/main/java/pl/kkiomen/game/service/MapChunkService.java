package pl.kkiomen.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kkiomen.game.generator.map.Chunks.Chunk;
import pl.kkiomen.game.generator.map.Chunks.Helper.Column;
import pl.kkiomen.game.generator.map.Chunks.Type.*;
import pl.kkiomen.game.model.MapChunk;
import pl.kkiomen.game.repository.MapChunkRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapChunkService {

    private final MapChunkRepository mapChunkRepository;

    @Autowired
    public MapChunkService(MapChunkRepository mapChunkRepository) {
        this.mapChunkRepository = mapChunkRepository;
    }

    public MapChunk addChunk(Chunk chunk){
        MapChunk mapChunk = new MapChunk();
        mapChunk.setX(chunk.getX());
        mapChunk.setY(chunk.getY());
        mapChunk.setTypeChunk(chunk.getTypeChunk());
        return mapChunkRepository.save(mapChunk);
    }

    public List<Chunk> findAll(){
        List<Chunk> chunks = new ArrayList<>();
        Iterable<MapChunk> all = mapChunkRepository.findAll();
        for (MapChunk mapChunk : all) {
            chunks.add(getChunkByTypeId(mapChunk.getX(),mapChunk.getY(),mapChunk.getTypeChunk()));
        }
        return chunks;
    }

    public ArrayList<Column> getChunksToRenderMap(int sizeMap){
        List<Chunk> getAllChunks = this.findAll();
        ArrayList<Column> result = new ArrayList<>(sizeMap);
        int iterator = 0;
        ArrayList<Chunk> chunks = new ArrayList<>(sizeMap);
        for (Chunk currentChunk : getAllChunks){
            iterator++;
            chunks.add(currentChunk);


            if(iterator == sizeMap){
                iterator = 0;
                result.add(new Column(chunks));
                chunks = new ArrayList<>(sizeMap);
            }
        }
        return result;
    }


    public static Chunk getChunkByTypeId(int x, int y, int type){
        return switch (type) {
            case 1 -> new ChunkGrass(x, y);
            case 2 -> new ChunkGrass2(x, y);
            case 3 -> new ChunkGrass3(x, y);
            case 4 -> new ChunkMarches1(x, y);
            case 5 -> new ChunkMountain1(x, y);
            case 6 -> new ChunkMountain2(x, y);
            case 7 -> new ChunkMountain3(x, y);
            case 8 -> new ChunkWater1(x, y);
            case 9 -> new ChunkWater2(x, y);
            case 10 -> new ChunkDesert1(x, y);
            case 11 -> new ChunkDesert2(x, y);
            default -> new ChunkGrass(x, y);
        };
    }


}
