package org.example.jparelationship3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
public class Student {
//ID , name , age , major ( all should not be empty )

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
    @NotEmpty(message = "major Must be  not be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

}
