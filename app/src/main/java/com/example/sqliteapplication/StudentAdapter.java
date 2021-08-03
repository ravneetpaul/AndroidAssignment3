package com.example.sqliteapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<StudentModel> {

    ArrayList<StudentModel> students;

    public StudentAdapter(Context context, ArrayList<StudentModel> students) {
        super(context, R.layout.student_card);
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        StudentModel student = students.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.student_card, parent, false);

        TextView name = (TextView) convertView.findViewById(R.id.data_name);
        TextView age = (TextView) convertView.findViewById(R.id.data_age);
        TextView contact = (TextView) convertView.findViewById(R.id.data_contact);

        name.setText(student.getName());
        age.setText(student.getAge());
        contact.setText(student.getContact());

        return convertView;
    }
}