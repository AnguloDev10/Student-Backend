package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student est){return  studentRepository.save(est);}

    public List<Student> getStudentList(){return studentRepository.findAll();}

    public Student getStudentById(Long id) throws NotFoundException{return  studentRepository.findById(id).orElseThrow( () -> new NotFoundException("Student with this Id:"+ id + "not found"));}
    public Student updateUserById(Student student){
        Optional<Student> studentOptional = studentRepository.findById(student.getId());

        if(studentOptional.isPresent()){
            Student newStudent = studentOptional.get();
            newStudent.setName(student.getName());
            newStudent.setAge(student.getAge());
            newStudent.setEmail(student.getEmail());
            newStudent.setDOB(student.getDOB());
            newStudent.setSkills(student.getSkills());

            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    public String deleteStudentById(Long id){
        studentRepository.deleteById(id);
        return "Student "+ id + "deleted";
    }




    // @GetMapping
   // public List<Student> getStudent(){return List.of(
   //         new Student(
   //                 1L,"Mariam", LocalDate.of(2000, Month.DECEMBER,5),21,"mariam.jamal",List.of(new Skill(1L,"ALTO","HIGH")))
   //1 );
    //}
}
