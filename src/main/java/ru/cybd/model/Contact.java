package ru.cybd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="contact")
@Table(name="contact")

public class Contact {

    @Id
    @Column(name="id_contact")
    @GeneratedValue(generator = "id_cont_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_cont_seq", sequenceName = "id_cont_seq", initialValue = 1, allocationSize = 1)
    private Long idContact;

    @JsonIgnore
    @OneToMany(mappedBy = "contact")
    private List<Customer> customers;

    @Column(name="telephone")
    private String telephone;

    @Column(name="email")
    private String email;
}
