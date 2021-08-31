package com.mts.StudentManagementJPA.repositories.Test;

import com.mts.StudentManagementJPA.entity.Student;
import com.mts.StudentManagementJPA.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testing() {
        Student student = Student.builder().email("tahirmuri45@gmail.com").firstName("tahir").lastName("muri").
                guardianName("mts")
                .guardianMobile("12345")
                .guardianEmail("tahirmuris@gmail.com").
                build();

        studentRepository.save(student);
    }
}