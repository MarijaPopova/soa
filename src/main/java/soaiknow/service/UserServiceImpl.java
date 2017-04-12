package soaiknow.service;

/**
 * Created by Popov on 11.4.2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import soaiknow.models.Role;
import soaiknow.models.User;
import soaiknow.repository.RoleRepository;
import soaiknow.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    public User save(String username, String password, String passwordConfirm, String role) {
        if(password.equals(passwordConfirm)){
            User user = new User();
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setUsername(username);
            Set<Role> roles = new HashSet<>();
            Role r = new Role();
            r.setName(role);
            roleService.createRoleIfNotFound(r);
            roles.add(r);
            user.setRoles(roles);
            return userRepository.save(user);
        }

        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if(user != null) {
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }

        return null;
    }
}
