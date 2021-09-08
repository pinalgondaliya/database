package com.oscar.career.myapplication.appdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1,entities = {Student.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract AppDatabaseQueries getAppQueries();
}
