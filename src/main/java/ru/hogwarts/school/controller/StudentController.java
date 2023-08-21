package ru.hogwarts.school.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
private final StudentService studentService;
public StudentController (StudentService studentService){this.studentService=studentService;}


@PostMapping()
    public Student createStudent(@RequestBody Student student){
    return studentService.createStudent(student);
    }
    @PutMapping("{idUp}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long idUp,@RequestBody Student student){
        Long id=idUp;
    Student upStudent=studentService.updateStudent(id, student);
        if (upStudent==null){return ResponseEntity.notFound().build();
        }
    return ResponseEntity.ok(upStudent);
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student student=studentService.getStudent(id);
    if (student==null){return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    return ResponseEntity.ok(studentService.getStudent(id));
    }
    @GetMapping()
    public ResponseEntity<Collection<Student>> findAll(){
        return ResponseEntity.ok(studentService.findAll());
    }
    @DeleteMapping("{id}")
    public Student deleteStudent(@PathVariable Long id){
    return studentService.deleteStudent(id);
    }
@GetMapping("/filter/{age}")
    public ResponseEntity<Collection<Student>> studFilter(@PathVariable int age){
    return ResponseEntity.ok(studentService.studFilter(age));
    }
}
