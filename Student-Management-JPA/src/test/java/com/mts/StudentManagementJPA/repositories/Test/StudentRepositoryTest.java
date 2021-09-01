package com.mts.StudentManagementJPA.repositories.Test;

import com.mts.StudentManagementJPA.entity.Guardian;
import com.mts.StudentManagementJPA.entity.Student;
import com.mts.StudentManagementJPA.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


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
                .Name("mts")
                .Mobile("12345")
                .Email("tahirmuri2@gmail.com")
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

    @Test
    public void testFindByFirstname()
    {
        List<Student> listStudents = studentRepository.findByFirstName("tahir");
        System.out.println("listStudents = " + listStudents);
    }

    @Test
    public void testFindByFirstNameContaining()
    {
        List<Student> listStudents = studentRepository.findByFirstNameContaining("tah");
        System.out.println("listStudents = " + listStudents);
    }

//    @Test
//    public void testFindByGuardianName()
//    {
//        List<Student> listStudents = studentRepository.findByGuardianName("mts");
//        System.out.println("listStudents = " + listStudents);
//    }

    @Test
    public void testGetStudentByEmail()
    {
        List<Student> listStudents = studentRepository.getStudentByEmail("tahirmuri1@gmail.com");
        System.out.println("listStudents = " + listStudents);
    }

    @Test
    public void testGetStudentFirstNameByEmail()
    {
        String firstName = studentRepository.getStudentFirstNameByEmail("tahirmuri1@gmail.com");
        System.out.println("Student FirstName = " + firstName);
    }

    @Test
    public void testGetStudentByEmailNative()
    {
        Student students = studentRepository.getStudentByEmailNative("tahirmuri1@gmail.com");
        System.out.println("listStudents = " + students);
    }

    @Test
    public void testGetStudentByEmailNativeParam()
    {
        Student students = studentRepository.getStudentByEmailNativeParam("tahirmuri1@gmail.com");
        System.out.println("listStudents = " + students);
    }

    @Test
    public void testUpdateFirstNameByEmail()
    {
        int i=studentRepository.updateFirstNameByEmail("tahirmuri1@gmail.com",
                "tahir new");
        System.out.println("i = " + i);
    }

//    @Test
//    public void testGetGuardianByEmail()
//    {
//        Guardian guardian = studentRepository.getGuardianByEmail("tahirmuri1@gmail.com");
//        System.out.println("Guardian = " + guardian);
//    }

//    @Test
//    public void testGetStudentByEmailAndGuardianName()
//    {
//        List<Student> listStudents = studentRepository.getStudentByEmailAndGuardianName("tahirmuri1@gmail.com","mts");
//        System.out.println("listStudents = " + listStudents);
//    }



}