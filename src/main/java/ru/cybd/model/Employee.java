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
@Entity(name="employee")
@Table(name="employee")

public class Employee {

    @Id
    @Column(name="id_employee")
    @GeneratedValue(generator = "id_employee_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_employee_seq", sequenceName = "id_employee_seq", initialValue = 1, allocationSize = 1)
    private Long idEmployee;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<User> users;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "id_specialization")
    private Specialization specialization;

    @Column(name="experience")
    private int experience;

    @ManyToOne
    @JoinColumn(name = "id_addres")
    private Addres addres;

    @ManyToOne
    @JoinColumn(name = "id_personal_data")
    private PersonalData personalData;

}
