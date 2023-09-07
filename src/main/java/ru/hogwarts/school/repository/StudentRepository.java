package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Collection<Student> findStudentsByAgeBetween(int startAge,int finalAge);
    @Query(value = "SELECT Count(name) AS total FROM  student_table",nativeQuery = true)
    Object getTotalStudentsById();
    @Query(value = "SELECT AVG(age) AS total FROM  student_table",nativeQuery = true)
    Object getAVGStudentsByAge();

    @Query(value = "SELECT * FROM  student_table ORDER BY id DESC LIMIT 5",nativeQuery = true)
    Collection<Student> getLastStudents();
}
