package com.ibraheem.android.habittrackerproject;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);

            habitDbHelper.addHabit(dateInt, HabitContract.HabitEntry.HABIT_1,
                    "Go Running everyday");
            habitDbHelper.addHabit(dateInt, HabitContract.HabitEntry.HABIT_2,
                    "study for school everyday");
            habitDbHelper.addHabit(dateInt, HabitContract.HabitEntry.HABIT_3,
                    "learn From udacity");
            habitDbHelper.addHabit(dateInt, HabitContract.HabitEntry.HABIT_4,
                    "Read A Book once in 2 weeks");
        Cursor cursor = habitDbHelper.readHabits();
        while (cursor.moveToNext()) {
            Log.v(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                    " " + cursor.getInt(2) + " " + cursor.getString(3));
            Log.e(TAG, "habit: " + cursor.getInt(0) + " " + cursor.getInt(1) +
                    " " + cursor.getInt(2) + " " + cursor.getString(3));
        }
    }
}