package org.example.jparelationship3.Service;

import lombok.RequiredArgsConstructor;
import org.example.jparelationship3.Api.ApiEXception;
import org.example.jparelationship3.Model.Course;
import org.example.jparelationship3.Model.Student;
import org.example.jparelationship3.Repository.CourseRepository;
import org.example.jparelationship3.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id , Student student){
        Student student1 = studentRepository.findStudentById(id);
        if(student1==null){
            throw new ApiEXception("Sorry not found student id!!");
        }
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
        studentRepository.save(student1);
    }


    public void deleteStudent(Integer id){
        Student student = studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiEXception("Sorry not found student id!!");
        }
        studentRepository.delete(student);
    }


    public void assignStudentToCourse(Integer student_id,Integer course_id){
        Student student = studentRepository.findStudentById(student_id);
        Course course =courseRepository.findCourseById(course_id);

        if(student==null){
            throw new ApiEXception("Sorry not found student id !!");
        }
        if(course==null){
            throw new ApiEXception("Sorry not found course id !!");
        }

        student.getCourses().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }


    public void changeMajor(Integer id , String major){
        Student student = studentRepository.findStudentById(id);

        if(student==null){
            throw new ApiEXception("Sorry not found student id!!");
        }

        for (Course course: student.getCourses()){
            course.getStudents().remove(student);
            courseRepository.save(course);
        }

        student.setMajor(major);
        student.setCourses(null);
        studentRepository.save(student);
    }
}
