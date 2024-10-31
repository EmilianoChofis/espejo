package utez.edu.mx.cleancheck.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.cleancheck.model.user.User;
import utez.edu.mx.cleancheck.security.model.UserDetailsImpl;
import utez.edu.mx.cleancheck.service.user.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService service;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> foundUser = service.findByEmail(email);
        if (foundUser.isPresent())
            return UserDetailsImpl.build(foundUser.get());
        throw new UsernameNotFoundException("UserNotFound");
    }

}
