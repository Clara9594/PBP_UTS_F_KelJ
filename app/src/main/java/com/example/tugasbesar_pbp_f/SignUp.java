package com.example.tugasbesar_pbp_f;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignUp extends AppCompatActivity {
    FirebaseAuth mAuth;
    private TextInputEditText lastName, email,
            password,country;
    public TextInputEditText firstName, phone;
    private SharedPreferences preferences;
    private MaterialButton btn;
    private ImageButton back;
    private ImageView profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SettingsMode.sharedPreferences = getSharedPreferences("night",0);
        Boolean booleanValue = SettingsMode.sharedPreferences.getBoolean("night_mode",true);
        if(booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        mAuth = FirebaseAuth.getInstance();

        btn = findViewById(R.id.btnLogin);
        back = findViewById(R.id.back);
        lastName = findViewById(R.id.lastNameInput);
        email = findViewById(R.id.mailInput);
        password = findViewById(R.id.passInput);
        country = findViewById(R.id.countryInput);
        profil = findViewById(R.id.profil);

        //Request For Camera Permission
//        if(ContextCompat.checkSelfPermission(SignUp.this,
//                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(SignUp.this,new String[]{
//                    Manifest.permission.CAMERA
//            },100);
//        }

//        profil.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                //Open Camera
//                Intent photo = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(photo,100);
//            }
//        });

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent login = new Intent(SignUp.this, Login.class);
                startActivity(login);
            }
        });

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String mail = String.valueOf(email.getText());
                String pass = String.valueOf(password.getText());
                String pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(mail.isEmpty()){
                    Toast.makeText(SignUp.this, "Please Enter Email!", Toast.LENGTH_SHORT).show();
                }
                else if(pass.isEmpty()){
                    Toast.makeText(SignUp.this, "Please Enter Password!", Toast.LENGTH_SHORT).show();
                }
                else if(pass.length()<6){
                    Toast.makeText(SignUp.this, "Password too short!", Toast.LENGTH_SHORT).show();
                }
                else if(!mail.matches(pattern)){
                    Toast.makeText(SignUp.this, "Email Invalid!", Toast.LENGTH_SHORT).show();
                }
                else if(!(pass.isEmpty() && mail.isEmpty())){
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(),
                            password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(SignUp.this, "Sign Up Successfully!", Toast.LENGTH_SHORT).show();
                                        email.setText("");
                                        password.setText("");
                                        Intent signUp = new Intent(SignUp.this, Login.class);
                                        startActivity(signUp);
                                    }
                                    else {
                                        Toast.makeText(SignUp.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100) {
//            //Get Capture Image
//            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
//            //Set Capture Image to ImageView
//            profil.setImageBitmap(captureImage);
//        }
//    }
}