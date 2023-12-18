package org.example.jparelationship3.Service;

import lombok.RequiredArgsConstructor;
import org.example.jparelationship3.Api.ApiEXception;
import org.example.jparelationship3.Model.Course;
import org.example.jparelationship3.Model.Student;
import org.example.jparelationship3.Repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;


    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id , Course course){
        Course course1 = courseRepository.findCourseById(id);
        if(course1==null){
            throw new ApiEXception("Sorry not found course id !!");
        }
        course1.setName(course.getName());
        courseRepository.save(course1);
    }


    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiEXception("Sorry not found course id!!");
        }
        courseRepository.delete(course);
    }


    public String getTeacherByCourse(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiEXception("Sorry not found course id!!");
        }
        return course.getTeacher().getName();
    }


    public Set<Student> getAllStudentByCourse(Integer id){

        Course course = courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiEXception("Sorry not found course id !!");
        }

        return course.getStudents();

    }


}
