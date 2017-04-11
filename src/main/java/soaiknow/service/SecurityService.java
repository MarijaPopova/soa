package soaiknow.service;

/**
 * Created by Popov on 11.4.2017.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}