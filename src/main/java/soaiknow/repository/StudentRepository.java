package soaiknow.repository;

import org.springframework.data.repository.CrudRepository;
import soaiknow.models.Student;

/**
 * Created by SimonaS on 17/03/2017.
 */
public interface StudentRepository extends CrudRepository<Student, Long>{
}