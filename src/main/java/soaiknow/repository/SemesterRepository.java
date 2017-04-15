package soaiknow.repository;

import org.springframework.data.repository.CrudRepository;
import soaiknow.models.Semester;

/**
 * Created by Popov on 15.4.2017.
 */
public interface SemesterRepository extends CrudRepository<Semester,Long> {
}
