package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

import java.util.List;

public class StudentEditActivity extends AppCompatActivity {
    EditText nameEt;
    EditText idEt;
    EditText phoneEt;
    EditText addressEt;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);
        Intent intent=getIntent();
        int pos=intent.getIntExtra("pos",0);
        List<Student> data= Model.instance.getAllStudents();
        Student s=data.get(pos);
        nameEt=findViewById(R.id.edit_name_et);
        nameEt.setText(s.getName());
        idEt=findViewById((R.id.edit_id_et));
        idEt.setText(s.getId());
        cb=findViewById(R.id.edit_cb);
        if(s.isFlag()){
            cb.setChecked(true);
        }
        phoneEt=findViewById(R.id.edit_phone_et);
        phoneEt.setText(s.getPhone());
        addressEt=findViewById(R.id.edit_address_et);
        addressEt.setText(s.getAddress());
    }
}