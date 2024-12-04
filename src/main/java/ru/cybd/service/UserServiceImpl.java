package ru.cybd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.cybd.exceptions.LoginAlreadyExistsException;
import ru.cybd.model.User;
import ru.cybd.model.UserAuthority;
import ru.cybd.model.UserRole;
import ru.cybd.repository.UserRepository;
import ru.cybd.repository.UserRolesRepository;

@RequiredArgsConstructor
@Service

public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRolesRepository userRolesRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registration(String login, String password, String surname, String name, String middle_name ) {
        if (userRepository.findByLogin(login).isEmpty()) {
            User user = userRepository.save(
                    new User()
                            .setId_user(null)
                            .setLogin(login)
                            .setPassword(passwordEncoder.encode(password))
                            .setSurname(surname)
                            .setName(name)
                            .setMiddle_name(middle_name)

            );
            userRolesRepository.save(new UserRole(null, UserAuthority.USER, user));
        } else {
            throw new LoginAlreadyExistsException();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
    }
}
