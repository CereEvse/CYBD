package ru.cybd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="addres")
@Table(name="addres")

public class Addres {

    @Id
    @Column(name="id_addres")
    @GeneratedValue(generator = "id_addr_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_addr_seq", sequenceName = "id_addr_seq", initialValue = 1, allocationSize = 1)
    private Long idAddres;

    @JsonIgnore
    @OneToMany(mappedBy = "addres")
    private List<Employee> employees;

    @Column(name="city")
    private String city;

    @Column(name="street")
    private String street;

    @Column(name="house")
    private String house;

}
