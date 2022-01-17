package am.gbr.web.util;

import am.gbr.common.entity.User;
import am.gbr.common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ApplicationStartListener implements ApplicationListener<ApplicationReadyEvent> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (userRepository.findByEmail("test.for.project.java.2021@gmail.com").isEmpty()) {
            userRepository.save(User.builder()
                    .email("test.for.project.java.2021@gmail.com")
                    .password(passwordEncoder.encode("admin"))
                    .name("admin")
                    .surname("surname")
                    .build());
        }

    }
}
