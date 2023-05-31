package com.example.attendance_fingerprint;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.attendance_fingerprint.bean.FacultyBean;
import com.example.attendance_fingerprint.db.DBAdapter;

public class AddFacultyActivity extends AppCompatActivity {

    Button registerButton,Cancel_Button;
    EditText textFirstName;
    EditText textLastName;
    EditText textemail;
    EditText textcontact;
    EditText textaddress;
    EditText textusername;
    EditText textpassword;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);


        textFirstName=(EditText)findViewById(R.id.editTextFirstName);
        textLastName=(EditText)findViewById(R.id.editTextLastName);
        textcontact=(EditText)findViewById(R.id.editTextPhone);
        textaddress=(EditText)findViewById(R.id.editTextaddr);
        textusername=(EditText)findViewById(R.id.editTextUserName);
        textpassword=(EditText)findViewById(R.id.editTextPassword);
        registerButton=(Button)findViewById(R.id.RegisterButton);
Cancel_Button=(Button)findViewById(R.id.Cancel_Button);
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String first_name = textFirstName.getText().toString();
                String last_name = textLastName.getText().toString();
                String phone_no = textcontact.getText().toString();
                String address = textaddress.getText().toString();
                String userName = textusername.getText().toString();
                String passWord = textpassword.getText().toString();

                if (TextUtils.isEmpty(first_name)) {
                    textFirstName.setError("please enter firstname");
                }
                else if (TextUtils.isEmpty(last_name)) {
                    textLastName.setError("please enter lastname");
                }
                else if (TextUtils.isEmpty(phone_no)) {
                    textcontact.setError("please enter phoneno");
                }

                else if (TextUtils.isEmpty(address)) {
                    textaddress.setError("enter address");
                }
                else if (TextUtils.isEmpty(userName)) {
                    textcontact.setError("please enter username");
                }
                else if (TextUtils.isEmpty(passWord)) {
                    textaddress.setError("enter password");
                }
                else {

                    FacultyBean facultyBean = new FacultyBean();
                    facultyBean.setFaculty_firstname(first_name);
                    facultyBean.setFaculty_lastname(last_name);
                    facultyBean.setFaculty_mobilenumber(phone_no);
                    facultyBean.setFaculty_address(address);
                    facultyBean.setFaculty_username(userName);
                    facultyBean.setFaculty_password(passWord);

                    DBAdapter dbAdapter = new DBAdapter(AddFacultyActivity.this);
                    dbAdapter.addFaculty(facultyBean);

                    Intent intent =new Intent(AddFacultyActivity.this,Menu.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Faculty added successfully", Toast.LENGTH_SHORT).show();

                }

            }
        });
/// cancel button

Cancel_Button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

      alertDialog=new AlertDialog.Builder((AddFacultyActivity.this));
      alertDialog.setTitle("Attendance Fingerprint App");
      alertDialog.setMessage("Are You Sure Cancel Transaction");
      alertDialog.setCancelable(false);
    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
           Intent intent=new Intent(AddFacultyActivity.this,Menu.class);
           startActivity(intent);
        }
    });
    alertDialog.setNegativeButton("No",new DialogInterface.OnClickListener()

            {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                  dialog.cancel();
                }
            });
        AlertDialog dialog= alertDialog.create();
    //    dialog.show();

    }
});

    }
}