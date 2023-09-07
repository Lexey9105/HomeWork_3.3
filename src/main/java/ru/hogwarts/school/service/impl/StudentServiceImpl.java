package ru.hogwarts.school.service.impl;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;



    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(Long id) {
        Optional<Student> student= studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();}
        else {throw new EntityNotFoundException("Студент с "+id+"id не существует");
        }
    }

    @Override
    public Student deleteStudent(Long id) {
            Optional<Student> student= studentRepository.findById(id);
            if(student.isPresent()){
               studentRepository.deleteById(id);
                return student.get();}
            else {throw new EntityNotFoundException("студент с "+id+"id не существует");
            }

    }
    @Override
public Collection<Student> findAll(){
        return studentRepository.findAll();
}
    @Override
    public Collection<Student> getByAge(int startAge,int finalAge) {

        return studentRepository.findStudentsByAgeBetween( startAge, finalAge);
    }
    @Override
    public Object TotalStudentsById(){
        return  studentRepository.getTotalStudentsById();
    }
    @Override
    public Object AVGStudentsByAge(){
        return studentRepository.getAVGStudentsByAge();
    }
    @Override
   public Collection<Student> LastStudents(){
        return studentRepository.getLastStudents();
   }



}
