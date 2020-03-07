package com.example.saurabhomer.qualityapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    EditText nametv;
    EditText mobiletv;
    EditText emailtv;
    EditText edt_user;
    EditText edt_pass;
    CheckBox adminCheck;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nametv =  findViewById(R.id.edt_name).findViewById(R.id.atvUsernameReg);
        mobiletv =  findViewById(R.id.edt_mobile).findViewById(R.id.atvUsernameReg);
        emailtv =  findViewById(R.id.edt_email).findViewById(R.id.atvUsernameReg);
        edt_user =  findViewById(R.id.edt_user).findViewById(R.id.atvUsernameReg);;
        edt_pass =  findViewById(R.id.edt_pass).findViewById(R.id.atvUsernameReg);;
        adminCheck =  (CheckBox)findViewById(R.id.adminCheck);
        Button submit =  findViewById(R.id.btnSignUp);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nametv.getText().toString().isEmpty() || edt_user.getText().toString().isEmpty() ||  edt_pass.getText().toString().isEmpty()){
                    Toast.makeText(SignUpActivity.this,"Some this is worng please check your data.",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.setMessage("Verificating...");
                progressDialog.show();
                UserProfile userProfile = new UserProfile();

                userProfile.setEmail(emailtv.getText().toString());
                userProfile.setMobileNumber(mobiletv.getText().toString());
                userProfile.setUsername(edt_user.getText().toString());
                userProfile.setName(nametv.getText().toString());
                userProfile.setPassword(edt_pass.getText().toString());
                if(adminCheck.isChecked())
                {
                    userProfile.setIsAdmin("1");
                }
                else {
                    userProfile.setIsAdmin("0");
                }
                sendUserData(userProfile);
            }
        });


    }


    private void sendUserData(UserProfile userProfile){

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = firebaseDatabase.getReference("users");

        users.child(userProfile.getUsername()).setValue(userProfile);
        finish();
        progressDialog.dismiss();

    }
}
