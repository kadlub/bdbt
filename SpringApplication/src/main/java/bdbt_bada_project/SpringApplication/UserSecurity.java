package bdbt_bada_project.SpringApplication;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("userSecurity")
public class UserSecurity {
    public boolean hasUserId(Authentication authentication, Long userId) {

        return authentication.getName().equals(userId.toString());
    }
}