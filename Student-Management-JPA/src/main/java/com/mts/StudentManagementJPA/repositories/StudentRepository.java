package com.mts.StudentManagementJPA.repositories;

import com.mts.StudentManagementJPA.entity.Guardian;
import com.mts.StudentManagementJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

   public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);


    @Query("select s from Student s where s.email = ?1")
    public List<Student> getStudentByEmail(String email);

 @Query("select s.firstName from Student s where s.email = ?1")
 String getStudentFirstNameByEmail(String email);

 //Native query
 @Query(value = "SELECT * From student where email_id = ?1",
 nativeQuery = true)
 Student getStudentByEmailNative(String email);

 //Native query
 @Query(value = "SELECT * From student where email_id = :email",
         nativeQuery = true)
 Student getStudentByEmailNativeParam(@Param("email") String email);

 @Modifying
 @Transactional
 //should have for the operation to be committed after execution , must do put it
 @Query(value = "update student set first_name= ?2 where email_id = ?1",
         nativeQuery = true)
 int updateFirstNameByEmail(String email, String firstname);

// @Query("select s.Guardian from Student s where s.email = ?1")
// Guardian getGuardianByEmail(String email);

}
