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

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User registration(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role) {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPasswordConfirm(password);
        newUser.setPassword(password);
        Set<Role> roles = new HashSet<>();
        Role admin = new Role();
        admin.setName(role);
        roles.add(admin);
        newUser.setRoles(roles);
        userService.save(newUser);
        return newUser;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.findByUsername(username);
        if(user.getPassword().equals(password)){
            return user;
        }

        return null;
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
