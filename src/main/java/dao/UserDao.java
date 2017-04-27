package dao;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Валентина on 25.04.2017.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
