package com.example.attendance_fingerprint;

import androidx.appcompat.app.AppCompatActivity;
import com.example.attendance_fingerprint.bean.AttendanceBean;
import com.example.attendance_fingerprint.context.ApplicationContext;
import com.example.attendance_fingerprint.db.DBAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    Button addStudent;
    Button addFaculty;
    Button viewStudent;
    Button viewFaculty;
    Button logout;
    Button attendancePerStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        addStudent =(Button)findViewById(R.id.buttonaddstudent);
        addFaculty =(Button)findViewById(R.id.buttonaddfaculty);
        viewStudent =(Button)findViewById(R.id.buttonViewstudent);
        viewFaculty =(Button)findViewById(R.id.buttonviewfaculty);
        logout =(Button)findViewById(R.id.buttonlogout);

        addStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Menu.this,AddStudentActivity.class);
                startActivity(intent);
            }
        });

        addFaculty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Menu.this,AddFacultyActivity.class);
                startActivity(intent);
            }
        });

        viewFaculty.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Menu.this,ViewFacultyActivity.class);
                startActivity(intent);
            }
        });


        viewStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Menu.this,ViewStudentActivity.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent =new Intent(Menu.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        attendancePerStudent=(Button)findViewById(R.id.attendancePerStudentButton);
        attendancePerStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                DBAdapter dbAdapter = new DBAdapter(Menu.this);
                ArrayList<AttendanceBean> attendanceBeanList=dbAdapter.getAllAttendanceByStudent();
                ((ApplicationContext)Menu.this.getApplicationContext()).setAttendanceBeanList(attendanceBeanList);

                Intent intent = new Intent(Menu.this,ViewAttendancePerStudentActivity.class);
                startActivity(intent);

            }
        });






    }
}