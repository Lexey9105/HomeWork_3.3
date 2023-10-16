package ru.hogwarts.school.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping()
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping()
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student upStudent = studentService.updateStudent(student);
        if (upStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(upStudent);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping()
    public ResponseEntity<Collection<Student>> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/filter")
    public ResponseEntity<Collection<Student>> getStudentsByAge(@RequestParam int startAge, @RequestParam int finalAge) {
        return ResponseEntity.ok(studentService.getByAge(startAge,finalAge));
    }

    @GetMapping("faculty/{idStudent}")
    public ResponseEntity<Faculty> getStudentFaculty(@PathVariable Long idStudent){
       Faculty faculty=studentService.getStudent(idStudent).getFaculty();
        return ResponseEntity.ok(faculty);
    }
}
