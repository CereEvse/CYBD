package ru.cybd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="project")
@Table(name="project")

public class Project {

    @Id
    @Column(name="id_project")
    @GeneratedValue(generator = "id_project_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_project_seq", sequenceName = "id_project_seq", initialValue = 1, allocationSize = 1)
    private Long idProject;

    @JsonIgnore
    @OneToMany (mappedBy = "project")
    private List<Customer> customers;

    @JsonIgnore
    @OneToMany (mappedBy = "project")
    private List<Task> tasks;

    @Column(name="title")
    private String title;

    @Column(name="deadlines")
    private Date deadlines;

    @Column(name="budget")
    private Long budget;

}
