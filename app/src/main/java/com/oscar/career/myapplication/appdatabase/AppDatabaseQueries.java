package com.oscar.career.myapplication.appdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AppDatabaseQueries {

    @Insert
    void insertStudentData(Student s);

    @Query("SELECT * FROM Student")
    List<Student> getStundetsData();

    @Query("DELETE FROM student WHERE student_enroll_no =:enroll")
    void deleteStudentDetails(int enroll);

    @Query("UPDATE Student SET student_name=:newName WHERE student_enroll_no=:enroll")
    void updateStudentDetails(int enroll,String newName);

}
