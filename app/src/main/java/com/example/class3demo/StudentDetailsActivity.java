package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {

    TextView nameEt;
    TextView idEt;
    TextView phoneEt;
    TextView addressEt;
    CheckBox cb;
Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Intent intent=getIntent();
        int pos=intent.getIntExtra("pos",0);
        Intent intentEdit = new Intent(this, StudentEditActivity.class);
        List<Student> data= Model.instance.getAllStudents();
        Student s=data.get(pos);
        nameEt=findViewById(R.id.details_nameText);
        nameEt.setText(s.getName());
        idEt=findViewById((R.id.details_idText));
        idEt.setText(s.getId());
        cb=findViewById(R.id.details_cb);
        if(s.isFlag()){
            cb.setChecked(true);
        }
        phoneEt=findViewById(R.id.details_phoneText);
        phoneEt.setText(s.getPhone());
        addressEt=findViewById(R.id.details_addressText);
        addressEt.setText(s.getAddress());
        edit=findViewById(R.id.details_button);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentEdit.putExtra("pos",pos);
                startActivity(intentEdit);
            }
        });
    }
}