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
@Entity(name="customer")
@Table(name="customer")

public class Customer {

    @Id
    @Column(name="id_customer")
    @GeneratedValue(generator = "id_cust_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_cust_seq", sequenceName = "id_cust_seq", initialValue = 1, allocationSize = 1)
    private Long idCustomer;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<User> users;

    @Column(name="name_company")
    private String nameCompany;

    @ManyToOne
    @JoinColumn(name = "id_contact")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;

    @Column(name="requirements")
    private String requirements;
}
