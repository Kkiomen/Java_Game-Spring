package pl.kkiomen.game.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkiomen.game.model.MapChunk;

public interface MapChunkRepository extends CrudRepository<MapChunk, Long> {
}
