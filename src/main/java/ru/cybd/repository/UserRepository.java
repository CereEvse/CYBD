package ru.cybd.repository;

import org.springframework.data.repository.CrudRepository;
import ru.cybd.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
