package com.example.attendance_fingerprint;

import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.attendance_fingerprint.bean.AttendanceBean;
import com.example.attendance_fingerprint.bean.StudentBean;
import com.example.attendance_fingerprint.context.ApplicationContext;
import com.example.attendance_fingerprint.db.DBAdapter;
import com.example.attendance_fingerprint.R;

import java.util.ArrayList;

public class ViewAttendancePerStudentActivity extends Activity {

    ArrayList<AttendanceBean> attendanceBeanList;
    private ListView listView ;
    private ArrayAdapter<String> listAdapter;

    DBAdapter dbAdapter = new DBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.__listview_main);

        listView=(ListView)findViewById(R.id.listview);
        final ArrayList<String> attendanceList = new ArrayList<String>();
        attendanceList.add("Present Count Per Student");
        attendanceBeanList=((ApplicationContext) com.example.attendance_fingerprint.ViewAttendancePerStudentActivity.this.getApplicationContext()).getAttendanceBeanList();

        for(AttendanceBean attendanceBean : attendanceBeanList)
        {
            String users = "";

            DBAdapter dbAdapter = new DBAdapter(com.example.attendance_fingerprint.ViewAttendancePerStudentActivity.this);
            StudentBean studentBean =dbAdapter.getStudentById(attendanceBean.getAttendance_student_id());
            users = attendanceBean.getAttendance_student_id()+".     "+studentBean.getStudent_firstname()+","+studentBean.getStudent_lastname()+"                  "+attendanceBean.getAttendance_session_id();
            attendanceList.add(users);
        }

        listAdapter = new ArrayAdapter<String>(this, R.layout.view_attendance_list_per_student, R.id.labelAttendancePerStudent, attendanceList);
        listView.setAdapter( listAdapter );


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}