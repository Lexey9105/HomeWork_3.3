package ru.hogwarts.school.service.impl;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Autowired
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
        else {throw new EntityNotFoundException("факульттет с "+id+"id не существует");
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
    public Collection<Student> studFilter(int age) {

        return studentRepository.findAll().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }
}
