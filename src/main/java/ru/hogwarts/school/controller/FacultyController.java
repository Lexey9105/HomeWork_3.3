package ru.hogwarts.school.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;
@Autowired
    public FacultyController (FacultyService facultyService){this.facultyService=facultyService;}


    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @PutMapping()
    public ResponseEntity<Faculty> updateFaculty( @RequestBody Faculty faculty){
        Faculty upFaculty=facultyService.updateFaculty(faculty);
        if (upFaculty==null){return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(upFaculty);
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long id){
        Long idUp=id;
        Faculty faculty=facultyService.getFaculty(idUp);
        if (faculty==null){return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(faculty);
    }
    @DeleteMapping("{id}")
    public Faculty deleteFaculty(@PathVariable Long id){
        return facultyService.deleteFaculty(id);
    }
    @GetMapping("/filter")
    public ResponseEntity<Collection<Faculty>> getFacultiesByColorOrName(@RequestParam String name,
                                                                         @RequestParam String color){
        return ResponseEntity.ok(facultyService.getByColorOrName(color,name));
    }

    @GetMapping("students/{id_faculty}")
    public ResponseEntity<Collection<Student>> getFacultyStudents(@PathVariable Long id_faculty){
         List <Student> students=facultyService.getFaculty(id_faculty).getStudents();
        return ResponseEntity.ok(students);
    }
}
