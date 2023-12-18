package org.example.jparelationship3.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.jparelationship3.Model.Student;
import org.example.jparelationship3.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor

public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.OK).body("adde");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id , @Valid@RequestBody Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(HttpStatus.OK).body("update");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete");
    }
    @PutMapping("/{student_id}/assign/{course_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer student_id,@PathVariable Integer course_id){
        studentService.assignStudentToCourse(student_id,course_id);
        return ResponseEntity.status(HttpStatus.OK).body("assigned");
    }
    @PutMapping("/changeMajor/{id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id,@PathVariable String major){
        studentService.changeMajor(id, major);
        return ResponseEntity.status(HttpStatus.OK).body("major changed");
    }
}
