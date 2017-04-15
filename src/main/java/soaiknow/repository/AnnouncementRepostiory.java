package soaiknow.repository;

import org.springframework.data.repository.CrudRepository;
import soaiknow.models.Announcement;

/**
 * Created by SimonaS on 15/04/2017.
 */
public interface AnnouncementRepostiory extends CrudRepository<Announcement, Long> {
}
