package ru.hogwarts.school.service;


import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);
    Faculty updateFaculty( Faculty faculty);
    Faculty getFaculty(Long id);
    Faculty deleteFaculty(Long id);
    Collection<Faculty> findAll();
    Collection<Faculty> facFilter(String color);
}
