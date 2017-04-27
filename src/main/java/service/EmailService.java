package service;

import org.springframework.stereotype.Service;

/**
 * Created by Валентина on 25.04.2017.
 */
@Service
public interface EmailService {
    void sendEmail(String fromAddress, String toAddress, String subject, String body);
}
