package com.mts.StudentManagementJPA.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "student",
uniqueConstraints = @UniqueConstraint(
        name = "email_unique_cons",
        columnNames = "email_id"
))
public class Student {

    @Id
    @Column(name = "student_id")
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(name = "email_id",
     nullable = false)
    private String email;
    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;

}
