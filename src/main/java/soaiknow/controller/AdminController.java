package soaiknow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soaiknow.models.Announcement;
import soaiknow.models.Subject;
import soaiknow.models.User;
import soaiknow.repository.AnnouncementRepostiory;
import soaiknow.repository.SubjectRepository;
import soaiknow.repository.UserRepository;
import soaiknow.service.UserService;

/**
 * Created by Popov on 14.4.2017.
 */
@RestController
@RequestMapping(value = "/")
public class AdminController {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AnnouncementRepostiory announcementRepostiory;

    @RequestMapping(value = "insertUser", method = RequestMethod.POST)
    public User insertUser(@RequestParam("name") String name, @RequestParam("lastName") String lastName,
                           @RequestParam("username") String username, @RequestParam("email") String email,
                           @RequestParam("embg") String embg, @RequestParam("password") String password,
                           @RequestParam("passwordConfirm") String passwordConfirm, @RequestParam("role") String role){
        return userService.save(name, lastName, username, email, embg, password, passwordConfirm, role);
    }

    @RequestMapping(value = "insertSubject", method = RequestMethod.POST)
    public Subject registration(@RequestParam("code") String code,
                                @RequestParam("nameSubject") String name,
                                @RequestParam("description") String description,
                                @RequestParam("professor") String professor) {

        Subject subject = new Subject(code, name, description, professor);
        return  subjectRepository.save(subject);
    }

    @RequestMapping(value = "insertAnnouncement", method = RequestMethod.POST)
    public Announcement addAnnouncement(@RequestParam("title") String title, @RequestParam("content") String content){
        Announcement announcement = new Announcement();
        announcement.setTitle(title);
        announcement.setContent(content);
        return announcementRepostiory.save(announcement);
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam("user") long id){
        userService.deleteUser(id);
    }

    @RequestMapping(value = "deleteSubject", method = RequestMethod.DELETE)
    public void deleteSubject(@RequestParam("subject") long id){
        subjectRepository.delete(id);
    }

    @RequestMapping(value = "deleteAnnouncement", method = RequestMethod.DELETE)
    public void deleteAnnouncement(@RequestParam("announcement") long id){
        announcementRepostiory.delete(id);
    }
}