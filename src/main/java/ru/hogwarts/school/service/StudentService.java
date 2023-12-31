package ru.hogwarts.school.service;


import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {

    Student createStudent(Student student);
    Student updateStudent(Long id, Student student);
    Student getStudent(Long id);
    Student deleteStudent(Long id);
     Collection<Student> findAll();
   Collection<Student> studFilter(int age);
}
