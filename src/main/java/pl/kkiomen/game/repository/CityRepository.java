package pl.kkiomen.game.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkiomen.game.model.City;

public interface CityRepository extends CrudRepository<City,Long> {
}
