package com.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Name Cannot Be Empty")
    private String name;

    @Column(name = "code")
    @NotEmpty(message = "Code Cannot Be Empty")
    private String code;

    @Column(name="address")
    @NotEmpty(message = "Address Cannot Be Empty")
    private String address;

    @Column(name = "birth_date")
    @NotNull(message = "Birth Date Is Required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name="mobile")
    @NotEmpty(message = "Mobile Cannot Be Empty")
    private String mobile;

    @Column(name="salary")
    @NotNull(message = "Salary Is Required")
    private double salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
//    @JsonIgnore
    private Department department;


}
