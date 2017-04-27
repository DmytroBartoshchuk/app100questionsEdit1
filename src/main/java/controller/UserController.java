package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.UserService;

/**
 * Created by Валентина on 25.04.2017.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;
}
