package soaiknow.repository;

/**
 * Created by Popov on 11.4.2017.
 */
import org.springframework.data.repository.CrudRepository;
import soaiknow.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
