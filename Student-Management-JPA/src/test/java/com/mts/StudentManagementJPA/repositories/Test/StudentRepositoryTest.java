package com.mts.StudentManagementJPA.repositories.Test;

import com.mts.StudentManagementJPA.entity.Guardian;
import com.mts.StudentManagementJPA.entity.Student;
import com.mts.StudentManagementJPA.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testing() {
        Student student = Student.builder().email("tahirmuri45@gmail.com").firstName("tahir").lastName("muri").
//                guardianName("mts")
//                .guardianMobile("12345")
//                .guardianEmail("tahirmuris@gmail.com").
                build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .guardianName("mts")
                .guardianMobile("12345")
                .guardianEmail("tahirmuri1@gmail.com")
                .build();
        Student student = Student.builder()
                .email("tahirmuri1@gmail.com")
                .firstName("tahir")
                .lastName("muri")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printStudent()
    {
        List<Student> listStudents = studentRepository.findAll();

        System.out.println("students = "+listStudents);
    }
}