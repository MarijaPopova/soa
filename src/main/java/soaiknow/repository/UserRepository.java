package soaiknow.repository;

/**
 * Created by Popov on 11.4.2017.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import soaiknow.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
