package com.oscar.career.myapplication.appdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    int pKey;

    @ColumnInfo(name = "student_name")
   public String name;

    @ColumnInfo(name = "student_enroll_no")
   public int enrollNo;


    public Student(String name, int enrollNo) {
        this.name = name;
        this.enrollNo = enrollNo;
    }
}
