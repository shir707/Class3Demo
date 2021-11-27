package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

import java.util.LinkedList;
import java.util.List;

public class StudentsListActivity extends AppCompatActivity {

    List<Student> data=new LinkedList<Student>();
Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        Intent intent=  new Intent(this, MainActivity.class);
        data= Model.instance.getAllStudents();
        add=findViewById(R.id.addNew);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);

            }
        });
      //reference to list
        ListView list=findViewById(R.id.studentlist_listv);
        MyAdapter adapter=new MyAdapter();
        list.setAdapter(adapter);
        Intent intentDetails = new Intent(this, StudentDetailsActivity.class);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //if we click on row we get the id of the row
                intentDetails.putExtra("pos",position);
                startActivity(intentDetails);             //   Log.d("TAG","click row"+ position);
            }
        });
    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null) {
                //the inflater know to create the view
                LayoutInflater inflater = getLayoutInflater();
                //we create the convert view
                convertView = inflater.inflate(R.layout.student_list_row, null);
                CheckBox cb=convertView.findViewById(R.id.listrow_cb);
                cb.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              //get the position
                                             int pos=Integer.parseInt(v.getTag().toString());
                                             Log.d("TAG","cbn position"+ pos);
                                             //save the flag by the checkbox
                                             Student s=data.get(pos);
                                             s.setFlag(cb.isChecked());
                                          }
                                      });
                        //the student that we get in position
                        Student student = data.get(position);
            }
                //get the reference to the text view in row
                TextView nameTv=convertView.findViewById(R.id.listrow_name_tv);
                TextView idTv=convertView.findViewById(R.id.listrow_id_tv);
                CheckBox cb=convertView.findViewById(R.id.listrow_cb);
                //the checkbox is point on the student
                cb.setTag(position);
                //the data by number of row
                Student student=data.get(position);

                nameTv.setText(student.getName());
                idTv.setText(student.getId());
                cb.setChecked(student.isFlag());


            return convertView;
        }
    }
}