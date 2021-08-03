package com.example.sqliteapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDataActivity extends AppCompatActivity {

    TextView heading;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        heading = findViewById(R.id.view_data_heading);
        listView = (ListView) findViewById(R.id.list_view);

        ArrayList<StudentModel> studentsList = getStudentList();

        if(studentsList.size() == 0)
            heading.setText("No data!");
        else{
            // Customer Array Adapter
            StudentAdapter studentAdapter = new StudentAdapter(this, studentsList);

            if(listView == null)
                Log.d("Error", "NULL");

            listView.setAdapter(studentAdapter);
        }

    }

    public ArrayList<StudentModel> getStudentList(){

        Cursor res = new DBHelper(this).getdata();
        ArrayList<StudentModel> studentsList = new ArrayList<>();

        while(res.moveToNext()){
            StudentModel student = new StudentModel();
            student.setName(res.getString(0));
            student.setAddress(res.getString(1));
            student.setAge(res.getString(2));
            studentsList.add(student);
        }
        return studentsList;
    }

}