package org.example.jparelationship3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher {
    //id , name , age , email , salary ( Add all required validation )

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "name Must be  not be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "age Must be  not be null")
    @Positive(message = "age Must be  number")
    @Column(columnDefinition = "int not null check(age>0)")
    private Integer age;
    @NotNull(message = "email should not be null")
    @Email(message = "should be valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotNull(message = "salary Must be  not be null")
    @Positive(message = "salary must be positive")
    @Column(columnDefinition = "int not null check(salary>0)")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;

}
