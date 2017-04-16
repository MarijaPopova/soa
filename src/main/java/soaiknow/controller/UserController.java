package soaiknow.controller;

/**
 * Created by Popov on 11.4.2017.
 */
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import soaiknow.models.Announcement;
import soaiknow.models.Role;
import soaiknow.models.Roles;
import soaiknow.models.User;
import soaiknow.repository.AnnouncementRepostiory;
import soaiknow.repository.RoleRepository;
import soaiknow.service.RoleService;
import soaiknow.service.SecurityService;
import soaiknow.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AnnouncementRepostiory announcementRepostiory;

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User registration(@RequestParam("name") String name, @RequestParam("lastName") String lastName,
                             @RequestParam("username") String username, @RequestParam("email") String email,
                             @RequestParam("embg") String embg, @RequestParam("password") String password,
                             @RequestParam("passwordConfirm") String passwordConfirm,
                             @RequestParam("role") String role) {
        return userService.save(name, lastName, username, email, embg, password, passwordConfirm, role);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.loginUser(username, password);
        securityService.autologin(username, password);
        System.out.println(securityService.findLoggedInUsername());
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Announcement> getAnnouncements(){
        List<Announcement> announcements = new ArrayList<>();
        announcementRepostiory.findAll().forEach(announcements::add);
        return announcements;
    }

}
