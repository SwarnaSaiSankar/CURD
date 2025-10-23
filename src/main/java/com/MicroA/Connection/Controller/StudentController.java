package com.MicroA.Connection.Controller;


import com.MicroA.Connection.Model.Student;
import com.MicroA.Connection.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;

//    Hello Hoe are yoU

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping("/get/byemail")
    public ResponseEntity<Optional<Student>> getByEmail(@RequestParam String email){
        return ResponseEntity.ok(studentService.findByEmail(email));
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateByEmail(@RequestParam String email,@RequestBody Student student){
        return ResponseEntity.ok(studentService.updateByEmail(email,student));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.ok("Studet deleted");
    }
}
