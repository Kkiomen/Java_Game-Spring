package pl.kkiomen.game.security.auth;

import pl.kkiomen.game.model.User;

import java.util.Optional;

public interface ApplicationUserDao {
    User selectApplicationUserByUsername(String username);
}
