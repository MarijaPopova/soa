package soaiknow.repository;

import org.springframework.data.repository.CrudRepository;
import soaiknow.models.RegisterSubject;
import soaiknow.models.Student;

import java.util.List;

/**
 * Created by SimonaS on 17/03/2017.
 */
public interface RegisterSubjectRepository extends CrudRepository<RegisterSubject, Long> {
    List<RegisterSubject> findByStudent(Student student);
}
