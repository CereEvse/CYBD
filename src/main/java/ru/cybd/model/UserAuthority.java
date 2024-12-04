package ru.cybd.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthority implements GrantedAuthority {

    USER, // Роль обычного пользователя
    EMPLOYEE, // Роль разработчика
    PROJECT_MANAGER,  // Роль менеджера проектов
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
