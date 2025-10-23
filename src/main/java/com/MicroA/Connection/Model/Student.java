package com.MicroA.Connection.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "students",uniqueConstraints = {
        @UniqueConstraint(columnNames ="email")
} )
@Setter
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "age")
    private Integer age;

    @ElementCollection
    @CollectionTable(name = "student_subjects",joinColumns = @JoinColumn(name = "student_subjects"))
    @Column(name = "subjects")
    private List<String> subjects;


    @ElementCollection
    @CollectionTable(name = "student_grades", joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyColumn(name = "subject")
    @Column(name = "grade")
    private Map<String, String> grades;


}
