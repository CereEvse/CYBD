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
@Entity(name="personal_data")
@Table(name="personal_data")

public class PersonalData {

    @Id
    @Column(name="id_personal_data")
    @GeneratedValue(generator = "id_personal_data_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_personal_data_seq", sequenceName = "id_personal_data_seq", initialValue = 1, allocationSize = 1)
    private Long idCustomer;

    @JsonIgnore
    @OneToMany (mappedBy = "personalData")
    private List<Employee> employees;

    @Column(name="passport_series")
    private Long passportSeries;

    @Column(name="passport_number")
    private Long passportNumber;

    @Column(name="photo")
    private String photo;
}
