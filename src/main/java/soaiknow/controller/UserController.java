package soaiknow.controller;

/**
 * Created by Popov on 11.4.2017.
 */
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import soaiknow.models.Role;
import soaiknow.models.Roles;
import soaiknow.models.User;
import soaiknow.repository.RoleRepository;
import soaiknow.service.RoleService;
import soaiknow.service.SecurityService;
import soaiknow.service.UserService;

import java.util.HashSet;
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

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User registration(@RequestParam("username") String name, @RequestParam("username") String lastName, @RequestParam("username") String username, @RequestParam("username") String email, @RequestParam("username") String embg, @RequestParam("password") String password, @RequestParam("password") String passwordConfirm, @RequestParam("role") String role) {
        return userService.save(name, lastName, username, email, embg, password, passwordConfirm, role);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.loginUser(username, password);
        return user;
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
