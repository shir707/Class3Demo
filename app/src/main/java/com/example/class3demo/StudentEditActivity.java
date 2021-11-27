package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button save,delete,cancle;
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
        Intent back=new Intent(this,StudentsListActivity.class);
        cancle=findViewById(R.id.edit_cancel_btn);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(back);
            }
        });
        save=findViewById(R.id.edit_save_btn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                String name=nameEt.getText().toString();
                String id=idEt.getText().toString();
                boolean flagCb=cb.isChecked();
                String phone=phoneEt.getText().toString();
                String address=addressEt.getText().toString();
                Student s=new Student(name,id,flagCb,phone,address);
                data.set(pos,s);*/
                Student s=data.get(pos);
                s.setFlag(cb.isChecked());
                s.setAddress(addressEt.getText().toString());
                s.setId(idEt.getText().toString());
                s.setName(nameEt.getText().toString());
                s.setPhone(phoneEt.getText().toString());
                startActivity(back);
            }
        });
        delete=findViewById(R.id.edit_deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(pos);
                startActivity(back);

            }
        });
    }
}