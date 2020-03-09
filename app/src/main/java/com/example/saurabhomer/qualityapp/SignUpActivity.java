package com.example.saurabhomer.qualityapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpActivity extends AppCompatActivity {
    EditText nametv;
    EditText mobiletv;
    EditText emailtv;
    EditText edt_user;
    EditText edt_pass;
    CheckBox adminCheck;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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

                if(!NetworkUtils.isNetworkConnected(SignUpActivity.this))
                {
                    return;
                }
                if(nametv.getText().toString().isEmpty() || edt_user.getText().toString().isEmpty() ||  edt_pass.getText().toString().isEmpty()){
                    Toast.makeText(SignUpActivity.this,"Some this is wrong please check your data.",Toast.LENGTH_SHORT).show();
                    return;
                }
                progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.setMessage("Verificating...");
                progressDialog.show();
                FirebaseDatabase.getInstance().getReference("users").child(edt_user.getText().toString().trim()).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.getValue()==null)
                        {

                            UserProfile userProfile = new UserProfile();

                            userProfile.setEmail(emailtv.getText().toString().trim());
                            userProfile.setMobileNumber(mobiletv.getText().toString().trim());
                            userProfile.setUsername(edt_user.getText().toString().trim());
                            userProfile.setName(nametv.getText().toString().trim());
                            userProfile.setPassword(edt_pass.getText().toString().trim());
                            if(adminCheck.isChecked())
                            {
                                userProfile.setIsAdmin("1");
                            }
                            else {
                                userProfile.setIsAdmin("0");
                            }
                             sendUserData(userProfile);
                        }
                        else {
                            progressDialog.hide();
                            Toast.makeText(SignUpActivity.this, "User name is exist please change user name", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }


    private void sendUserData(UserProfile userProfile){

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = firebaseDatabase.getReference("users");

        users.child(userProfile.getUsername()).setValue(userProfile);
        Toast.makeText(SignUpActivity.this, "User name is added", Toast.LENGTH_SHORT).show();

        finish();
        progressDialog.dismiss();

    }
}
