package ru.cybd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="task")
@Table(name="task")

public class Task {

    @Id
    @Column(name="id_task")
    @GeneratedValue(generator = "id_task_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_task_seq", sequenceName = "id_task_seq", initialValue = 1, allocationSize = 1)
    private Long idProject;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    @Column(name="task")
    private String task;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
}
