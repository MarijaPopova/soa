package soaiknow.service;

import soaiknow.models.User;

/**
 * Created by Popov on 11.4.2017.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
