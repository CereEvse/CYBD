package ru.cybd.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@ToString

public class User implements UserDetails {

    @Id
    @SequenceGenerator(sequenceName = "user_id_seq", name = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id_user;
    private String login;
    private String password;

    @OneToMany (mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<UserRole> userRoles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userRoles.stream().map(UserRole::getUserAuthority).collect(Collectors.toList());
    }

    @Column(name="surname")
    private String surname;

    @Column(name="name")
    private String name;

    @Column(name="middle_name")
    private String middle_name;

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

}
