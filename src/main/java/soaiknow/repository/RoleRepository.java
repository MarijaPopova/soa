package soaiknow.repository;

/**
 * Created by Popov on 11.4.2017.
 */
import org.springframework.data.repository.CrudRepository;
import soaiknow.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
