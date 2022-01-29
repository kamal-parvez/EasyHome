package com.example.username.easyhome;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private EditText txtName;
    private EditText txtEmail;
    private EditText address;
    private EditText txtPassword1;
    private EditText txtPassword2;
    private Button signup;

    //private ProgressBar progressBar;
    private FirebaseAuth auth;
    DatabaseReference databaseAd;

    private String strEmail;
    private String strName;
    private String strAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //Toast.makeText(getApplicationContext(), "yjknmbnn", Toast.LENGTH_SHORT).show();

        txtName = (EditText) findViewById(R.id.name);
        txtEmail = (EditText) findViewById(R.id.email);
        address = (EditText) findViewById(R.id.address);
        txtPassword1 = (EditText) findViewById(R.id.password1);
        txtPassword2 = (EditText) findViewById(R.id.password2);
        signup = (Button) findViewById(R.id.SignUp);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strEmail = txtEmail.getText().toString();
                strName= txtName.getText().toString();
                strAdd= address.getText().toString();
                String pass1 = txtPassword1.getText().toString();
                String pass2 = txtPassword1.getText().toString();

                Toast.makeText(SignUpActivity.this, "Password is", Toast.LENGTH_SHORT).show();


               if(pass1.equals(pass2)){
                    register(strName, strEmail, pass1);
                    saveInfo();
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Password is not matched", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void register(String name, String email, String pass){

        Toast.makeText(getApplicationContext(), "register enter", Toast.LENGTH_SHORT).show();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(SignUpActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(SignUpActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(SignUpActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (pass.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

       // progressBar.setVisibility(View.VISIBLE);

        auth = FirebaseAuth.getInstance();

        //Log.d("uuuu" ,"hi");

        Task<AuthResult> authResultTask = auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUpActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        //progressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            //Toast.makeText(SignUpActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignUpActivity.this, Category.class));
                            //finish();
                        }
                    }
                });

        /*auth.createUserWithEmailAndPassword("jamal@gmail.com","amra12345")
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUpActivity.this, "user created", Toast.LENGTH_LONG);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(SignUpActivity.this, "user not created", Toast.LENGTH_LONG);

            }
        });*/


    }


    private void saveInfo(){

        PostInfo postInfo = new PostInfo(strName, strEmail, strAdd);

        databaseAd = FirebaseDatabase.getInstance().getReference("Account");
        String id = databaseAd.push().getKey();
        databaseAd.child(id).setValue(postInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {

                    Toast.makeText(SignUpActivity.this,"Stored",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(SignUpActivity.this,"Error",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
