package soaiknow.service;

import soaiknow.models.Role;

/**
 * Created by SimonaS on 12/04/2017.
 */
public interface RoleService {
    void createRoleIfNotFound(Role role);
}
