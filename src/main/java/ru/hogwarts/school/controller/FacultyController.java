package ru.hogwarts.school.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;


@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController (FacultyService facultyService){this.facultyService=facultyService;}


    @PostMapping
    public Faculty createStudent(@RequestBody Faculty faculty){
        return facultyService.createFaculty(faculty);
    }
    @PutMapping("{idUp}")
    public ResponseEntity<Faculty> updateStudent(@PathVariable Long idUp, @RequestBody Faculty faculty){
        Long id=idUp;
        Faculty upFaculty=facultyService.updateFaculty(id, faculty);
        if (upFaculty==null){return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(upFaculty);
    }
    @GetMapping("{id}")
    public ResponseEntity<Faculty> getStudent(@PathVariable Long id){
        Long idUp=id;
        Faculty faculty=facultyService.getFaculty(idUp);
        if (faculty==null){return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(faculty);
    }
    @DeleteMapping("{id}")
    public Faculty deleteStudent(@PathVariable Long id){
        return facultyService.deleteFaculty(id);
    }
    @GetMapping("/filter/{color}")
    public ResponseEntity<Collection<Faculty>> studFilter(@PathVariable String color){
        return ResponseEntity.ok(facultyService.facFilter(color));
    }
}
