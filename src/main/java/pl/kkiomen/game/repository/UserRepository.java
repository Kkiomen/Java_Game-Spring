package pl.kkiomen.game.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kkiomen.game.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
