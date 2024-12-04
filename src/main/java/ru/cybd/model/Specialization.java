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
@Entity(name="specialization")
@Table(name="specialization")

public class Specialization {

    @Id
    @Column(name="id_specialization")
    @GeneratedValue(generator = "id_spec_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_spec_seq", sequenceName = "id_spec_seq", initialValue = 1, allocationSize = 1)
    private Long idSpecialization;

    @JsonIgnore
    @OneToMany(mappedBy = "specialization")
    private List<Employee> employees;

    @Column(name="title")
    private String title;
}
