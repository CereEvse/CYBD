package ru.cybd.repository;

import org.springframework.data.repository.CrudRepository;
import ru.cybd.model.UserRole;

public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
}
