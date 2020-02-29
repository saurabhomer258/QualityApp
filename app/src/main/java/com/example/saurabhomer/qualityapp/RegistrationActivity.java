
package com.example.saurabhomer.qualityapp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    private ImageView logo, joinus;
    private AutoCompleteTextView username, email, password;
    private Button signup;
    private TextView signin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        initializeGUI();
        View et_username = findViewById(R.id.et_username);
        final EditText editText_username = et_username.findViewById(R.id.atvUsernameReg);
        View et_password = findViewById(R.id.et_password);
        final EditText editText_password = et_password.findViewById(R.id.atvUsernameReg);

        View signin_button = findViewById(R.id.bt_signin);
        Button bt_signin_button= signin_button.findViewById(R.id.btnSignUp);
        bt_signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText_username.getText().toString();
                String password = editText_password.getText().toString();
                signIn(username,password);
            }
        });
    }


    public void signIn(String username, String password)
    {

    }


    private void initializeGUI(){

        logo = (ImageView) findViewById(R.id.ivRegLogo);
        joinus = (ImageView) findViewById(R.id.ivJoinUs);
        View userNameView = findViewById(R.id.et_username);

        username = (AutoCompleteTextView) userNameView.findViewById(R.id.atvUsernameReg);
        username.setHint("hhh");
        View passwordView = findViewById(R.id.et_password);
        AutoCompleteTextView password = passwordView.findViewById(R.id.atvUsernameReg);
        password.setHint("anhaand");

//        email =  (AutoCompleteTextView) findViewById(R.id.atvEmailReg);
//        password = (AutoCompleteTextView) findViewById(R.id.atvPasswordReg);
        signin = (TextView) findViewById(R.id.tvSignIn);
        signup = (Button) findViewById(R.id.btnSignUp);
        progressDialog = new ProgressDialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void registerUser(final String inputName, final String inputPw, String inputEmail) {

        progressDialog.setMessage("Verificating...");
        progressDialog.show();


            firebaseAuth.createUserWithEmailAndPassword(inputEmail,inputPw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserData(inputName, inputPw);
                        Toast.makeText(RegistrationActivity.this,"You've been registered successfully.",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(RegistrationActivity.this,"Email already exists.",Toast.LENGTH_SHORT).show();
                    }
                }
            });

    }


    private void sendUserData(String username, String password){

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = firebaseDatabase.getReference("users");
        UserProfile user = new UserProfile(username, password);
        users.push().setValue(user);

    }

    private boolean validateInput(String inName, String inPw, String inEmail){

        if(inName.isEmpty()){
            username.setError("Username is empty.");
            return false;
        }
        if(inPw.isEmpty()){
            password.setError("Password is empty.");
            return false;
        }
        if(inEmail.isEmpty()){
            email.setError("Email is empty.");
            return false;
        }

        return true;
    }


}
