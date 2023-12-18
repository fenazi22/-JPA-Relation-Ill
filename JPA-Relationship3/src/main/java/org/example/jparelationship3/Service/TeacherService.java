package org.example.jparelationship3.Service;

import lombok.RequiredArgsConstructor;
import org.example.jparelationship3.Api.ApiEXception;
import org.example.jparelationship3.Model.Address;
import org.example.jparelationship3.Model.Course;
import org.example.jparelationship3.Model.Teacher;
import org.example.jparelationship3.Repository.CourseRepository;
import org.example.jparelationship3.Repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;


    public List<Teacher> getTeachers(){

        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }


    public void updateTeacher(Integer id , Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if(teacher1==null){
            throw new ApiEXception("Sorry not found teacher id!!");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }


    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiEXception("Sorry not found teacher id!!");
        }
        teacherRepository.delete(teacher);
    }

    public Address allTeacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiEXception("Teacher id not found");
        }
        if(teacher.getAddress()==null){
            throw new ApiEXception("address not found");
        }

        return teacher.getAddress();
    }

    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){

        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        Course course = courseRepository.findCourseById(course_id);
        if(teacher==null){
            throw new ApiEXception("Sorry not found teacher id!!");
        }
        if(course==null){
            throw new ApiEXception("Sorry  not found course id!!");
        }

        course.setTeacher(teacher);
        courseRepository.save(course);

    }

}
