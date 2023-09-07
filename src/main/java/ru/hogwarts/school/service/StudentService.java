package ru.hogwarts.school.service;


import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;

import java.io.IOException;
import java.util.Collection;

public interface StudentService {

    Student createStudent(Student student);
    Student updateStudent( Student student);
    Student getStudent(Long id);
    Student deleteStudent(Long id);
     Collection<Student> findAll();
   Collection<Student> getByAge(int startAge,int finalAge);
    Object TotalStudentsById();
    Object AVGStudentsByAge();
    Collection<Student> LastStudents();


}
