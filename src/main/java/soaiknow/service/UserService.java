package soaiknow.service;

import soaiknow.models.User;

/**
 * Created by Popov on 11.4.2017.
 */
public interface UserService {
    User save(String name, String lastName, String username, String email, String embg, String password, String passwordConfirm, String role);
    User findByUsername(String username);
    User loginUser(String username, String password);
}
