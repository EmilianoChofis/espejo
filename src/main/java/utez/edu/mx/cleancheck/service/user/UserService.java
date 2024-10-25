package utez.edu.mx.cleancheck.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.cleancheck.model.user.User;
import utez.edu.mx.cleancheck.model.user.UserRepository;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor

public class UserService {

    private final UserRepository repository;

    @Transactional(readOnly = true)
    public Optional<User> findByEmail (String email) {
        return repository.findByEmail(email);
    }
}
