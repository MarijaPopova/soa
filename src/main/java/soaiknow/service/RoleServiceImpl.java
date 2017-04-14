package soaiknow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soaiknow.models.Role;
import soaiknow.repository.RoleRepository;

import java.util.List;

/**
 * Created by SimonaS on 12/04/2017.
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void createRoleIfNotFound(Role role) {

        List<Role> r = roleRepository.findByName(role.getName());

        if(r.isEmpty()) {
            roleRepository.save(role);
        }
    }
}
