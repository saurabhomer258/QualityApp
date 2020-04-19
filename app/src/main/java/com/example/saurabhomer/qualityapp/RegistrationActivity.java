
package com.example.saurabhomer.qualityapp;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.service.autofill.UserData;
import android.support.annotation.NonNull;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurabhomer.qualityapp.pref.LoginPref;
import com.example.saurabhomer.qualityapp.utils.NetworkUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        progressDialog = new ProgressDialog(this);
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
    public void signIn(final String username, final String password)
    {
            if(!NetworkUtils.isNetworkConnected(this))
            {

                return;
            }
        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference users = firebaseDatabase.getReference("users");
        progressDialog.setMessage("Verificating...");
        progressDialog.show();
        users.child(username).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                    UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                    if (userProfile!= null && userProfile.getUsername()!=null && username.trim().toLowerCase().equals(userProfile.getUsername().trim().toLowerCase()) && password.trim().toLowerCase().equals(userProfile.getPassword().trim().toLowerCase())){

                        LoginPref.getInstance(RegistrationActivity.this).setUsername(userProfile.getName(),userProfile.getIsAdmin());

                        Intent intent = new Intent(RegistrationActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        progressDialog.hide();
                        Toast.makeText(RegistrationActivity.this,"User name or password is worng",Toast.LENGTH_LONG).show();
                    }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.hide();

            }

        });



    }


    private void initializeGUI(){

        logo = (ImageView) findViewById(R.id.ivRegLogo);
        joinus = (ImageView) findViewById(R.id.ivJoinUs);
        View userNameView = findViewById(R.id.et_username);

        username = (AutoCompleteTextView) userNameView.findViewById(R.id.atvUsernameReg);
        username.setHint("username");
        View passwordView = findViewById(R.id.et_password);
        EditText password = passwordView.findViewById(R.id.atvUsernameReg);


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
