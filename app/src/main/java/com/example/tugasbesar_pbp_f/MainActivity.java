package com.example.tugasbesar_pbp_f;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    //Initialize Variable;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        drawerLayout
        SettingsMode.sharedPreferences = getSharedPreferences("night",0);
        Boolean booleanValue = SettingsMode.sharedPreferences.getBoolean("night_mode",true);
        if(booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String CHANNEL_ID = "Channel 1";
            CharSequence name = "Channel 1";
            String description = "This is Channel 1";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        FirebaseMessaging.getInstance().subscribeToTopic("news")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String mag = "Successful";
                        if(!task.isSuccessful()){
                            mag = "Failed";
                        }
                        Toast.makeText(MainActivity.this, mag, Toast.LENGTH_SHORT).show();
                    }
                });
        //Assign variable
            drawerLayout = findViewById(R.id.drawer_layout);
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void ClickLogo(View view){
        //close drawer
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        try
        {
            if(drawerLayout.isDrawerOpen(GravityCompat.START))
            {
                //when drawer is open
                //close drawer
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        }catch (Exception E)
        {
            System.out.println("peyebab probably: " +E.getLocalizedMessage());
        }
//javatpoint.com
        //tutorialspoint.com
        //developer.google.com
        //dicoding.com / sanbercode /
        //porta
    }

    public void ClickHome(View view){
        recreate();
    }

    public void ClickProfil(View view){
        //Redirect activity to Home
        redirectActivity(this,Profile.class);
    }

    public void ClickSettings(View view){
        redirectActivity(this,SettingsMode.class);
    }

    public void ClickAbout(View view){
        redirectActivity(this,About.class);
    }

    public void ClickSignOut(View view){
        logout(this);
    }

    public static void logout(final Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure want to logout?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                SharedPreferences.Editor editor =  Login.statusLogin.edit();
                editor.putBoolean("status_login",false);
                editor.commit();
                activity.finishAffinity();
                System.exit(0);
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        closeDrawer(drawerLayout);
    }
}