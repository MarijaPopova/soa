package soaiknow.repository;

import org.springframework.data.repository.CrudRepository;
import soaiknow.models.RegisterSubject;
import soaiknow.models.User;

import java.util.List;

/**
 * Created by SimonaS on 17/03/2017.
 */
public interface RegisterSubjectRepository extends CrudRepository<RegisterSubject, Long> {
    List<RegisterSubject> findByUserIdAndExamSession(long id, String examSession);
    List<RegisterSubject> findBySubjectId(long id);
    RegisterSubject findByUserIdAndSubjectId(long user_id, long subject_id);
}
