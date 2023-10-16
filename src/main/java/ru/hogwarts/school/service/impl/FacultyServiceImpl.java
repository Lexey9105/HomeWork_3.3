package ru.hogwarts.school.service.impl;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.service.FacultyService;


import java.util.Collection;

import java.util.Optional;
import java.util.stream.Collectors;




@Service
public class FacultyServiceImpl implements FacultyService {

   private final FacultyRepository facultyRepository;
@Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository) {

        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFaculty(Long id) {
       Optional<Faculty>faculty= facultyRepository.findById(id);
        if(faculty.isPresent()){
        return faculty.get();}
        else {throw new EntityNotFoundException("факульттет с "+id+"id не существует");
        }
    }

    @Override
    public Faculty deleteFaculty(Long id) {
        Optional<Faculty>faculty= facultyRepository.findById(id);
        if(faculty.isPresent()){
             facultyRepository.deleteById(id);
            return faculty.get();}
        else
        {throw new EntityNotFoundException("факульттет с "+id+"id не существует");
        }
    }
    @Override
    public Collection<Faculty> findAll(){
        return facultyRepository.findAll();
    }
    @Override
    public Collection<Faculty> getByColorOrName(String name, String color) {
        return facultyRepository.findFacultiesByNameIgnoreCaseOrColorIgnoreCase( name,  color);
    }
}
