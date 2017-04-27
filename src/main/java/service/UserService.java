package service;

import model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Валентина on 25.04.2017.
 */

public interface UserService extends UserDetailsService {
    List<User> findAll();
    void save(User user);
    void delete(Long id);
    User findByEmail(String email);

}
