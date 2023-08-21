package ru.hogwarts.school.service.impl;


import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> storageStud;
    private Long size = 0L;

    public StudentServiceImpl() {
        this.storageStud = new HashMap<>();
    }

    @Override
    public Student createStudent(Student student) {
        size++;
Student student1=student;
        student1.setId(size);
        storageStud.put(student1.getId(), student1);
        return student1;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        if(!storageStud.containsKey(id)){return null;}
        Student student1=student;
        storageStud.put(id, student1);
        return student;
    }

    @Override
    public Student getStudent(Long id) {
        return  storageStud.get(id);
    }

    @Override
    public Student deleteStudent(Long id) {
        if (!storageStud.containsKey(id)) {
            throw new RuntimeException("Сотрудник уже добавлен");
        }
        if (id == null || id == 0) {
            throw new RuntimeException("введен пустой запрос");
        }
        storageStud.get(id);
        Student student = storageStud.get(id);
        storageStud.remove(id);
        size--;
        return student;
    }
    @Override
public Collection<Student> findAll(){
        return storageStud.values();
}
    @Override
    public Collection<Student> studFilter(int age) {

        return storageStud.values().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }
}
