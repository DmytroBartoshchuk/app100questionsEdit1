package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.EmailService;
import service.UserService;

import org.apache.log4j.*;

/**
 * Created by Валентина on 25.04.2017.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    private final static Logger logger = Logger.getLogger(MainController.class.getName());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMainPage(){
        return "main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage() {
        return "register";
    }

    //gdy user zatwierdzi dane do rejestracji
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute User user) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(SecurityConfig.PASSWORD_STRENGHT);
            String passwordEncoded = encoder.encode(user.getPassword());
            user.setPassword(passwordEncoded);
            userService.save(user);
        } catch(Exception ex) {
            logger.error(ex.getMessage());
            System.out.println(ex.getMessage());

            return "redirect:/register";
        }

        emailService.sendEmail("app100questions@gmail.com", user.getEmail(), "UDANA REJESTRACJA", "Welcome " + user.getUsername());

        return "redirect:/login";
    }
}
