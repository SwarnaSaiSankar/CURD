package com.MicroA.Connection.Service;

import com.MicroA.Connection.Model.Student;
import com.MicroA.Connection.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> getById(Long id){
        return studentRepository.findById(id);
    }

    public Optional<Student> findByEmail(String email){
        return studentRepository.findByEmail(email);
    }

    public Student updateByEmail(String email, Student student){
        if (!Objects.equals(email, student.getEmail())) throw new RuntimeException("Email doesn't match");

        Optional<Student> updatedOne=studentRepository.findByEmail(email);

        Student existing = updatedOne.get();

        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setSubjects(student.getSubjects());
        existing.setGrades(student.getGrades());

        return studentRepository.save(existing);
    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
}
