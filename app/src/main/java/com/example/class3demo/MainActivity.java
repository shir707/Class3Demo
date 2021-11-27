package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText nameEt;
    EditText idEt;
    EditText phoneEt;
    EditText addressEt;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt=findViewById(R.id.main_name_et);
        idEt=findViewById((R.id.main_id_et));
        cb=findViewById(R.id.main_cb);
        phoneEt=findViewById(R.id.main_phone_et);
        addressEt=findViewById(R.id.main_address_et);
        Button saveBtn=findViewById(R.id.main_save_btn);
        Button cancelBtn=findViewById(R.id.main_cancel_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
/*


        Button btn=findViewById(R.id.main_my_btn);
        title=findViewById(R.id.main_title_tv);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                title.setText("Button was clicked");
            }
        });
 */
    }

    private void save() {
        //we need to read what we have in the edit text;
        String name=nameEt.getText().toString();
        String id=idEt.getText().toString();
        boolean flagCb=cb.isChecked();
        String phone=phoneEt.getText().toString();
        String address=addressEt.getText().toString();
        Student s=new Student(name,id,flagCb,phone,address);
        List<Student> data= Model.instance.getAllStudents();
        data.add(s);
        //printing what we read from the user
       
    }


}