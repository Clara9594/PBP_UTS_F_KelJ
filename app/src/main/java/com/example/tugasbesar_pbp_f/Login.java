package com.example.tugasbesar_pbp_f;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    public EditText edtEmail,edtPassword;
    public Button btnSignIn;
    private MaterialButton btn;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    static SharedPreferences statusLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SettingsMode.sharedPreferences = getSharedPreferences("night",0);
        Boolean booleanValue = SettingsMode.sharedPreferences.getBoolean("night_mode",true);
        if(booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        mFirebaseAuth = FirebaseAuth.getInstance();
        edtEmail = findViewById(R.id.emailInput);
        edtPassword = findViewById(R.id.passwordInput);
        btnSignIn = findViewById(R.id.btnLogin);
        btn = findViewById(R.id.btnSignUp);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent signUp = new Intent(Login.this, SignUp.class);
                startActivity(signUp);
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser!=null){
                    //Toast.makeText(MainActivity.this,"You are logged in!",Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    //startActivity(i);
                }
                else{
                    //Toast.makeText(MainActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if(email.isEmpty()){
                    Toast.makeText(Login.this, "Please enter your email!", Toast.LENGTH_SHORT).show();
                }
                else if(password.isEmpty()){
                    Toast.makeText(Login.this,"Please enter your password",Toast.LENGTH_SHORT).show();
                }

                else if(!(email.isEmpty() && password.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Login.this, "Log In Error, please try again!", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                SharedPreferences.Editor editor = statusLogin.edit();
                                editor.putBoolean("status_login",true);
                                editor.commit();
                                Toast.makeText(Login.this, "Log In Successfully", Toast.LENGTH_SHORT).show();
                                Intent intToHome = new Intent(Login.this,DateActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Login.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}