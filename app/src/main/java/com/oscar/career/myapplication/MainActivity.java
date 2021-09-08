package com.oscar.career.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.oscar.career.myapplication.appdatabase.AppDatabase;
import com.oscar.career.myapplication.appdatabase.AppDatabaseQueries;
import com.oscar.career.myapplication.appdatabase.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Sqlite database : SqliteOpenHelper, Room library

    AppDatabaseQueries myQueries;

    EditText name, enroll;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase myAppDb = Room.databaseBuilder(this, AppDatabase.class, "App_stundets_details").allowMainThreadQueries().build();
        myQueries = myAppDb.getAppQueries();

        name = findViewById(R.id.editTextTextPersonName);
        enroll = findViewById(R.id.editTextTextPersonName2);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void InsertDetails(View view) {

        String n = name.getText().toString();
        String e = enroll.getText().toString();
        int enroll = Integer.parseInt(e);

        Student s = new Student(n, enroll);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).run();
        myQueries.insertStudentData(s);
    }

    public void updateDetails(View view) {

        String newName = name.getText().toString();
        String e = enroll.getText().toString();
        int en = Integer.parseInt(e);
        myQueries.updateStudentDetails(en,newName);
    }

    public void deleteDetails(View view) {

        String e = enroll.getText().toString();
        int en = Integer.parseInt(e);
        myQueries.deleteStudentDetails(en);
    }

    public void getAllRecords(View view) {
       List<Student> s =  myQueries.getStundetsData();
       rv.setAdapter(new RecAdapter(s));
    }
}