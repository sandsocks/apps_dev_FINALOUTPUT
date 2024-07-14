package com.example.fo_sandejas_villanueva;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class LoginRegisterScreen extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginregister_screen);

        ImageButton button=findViewById(R.id.login_page_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginRegisterScreen.this,RegisterScreen.class);
                startActivity(intent);
            }
        });
        button=findViewById(R.id.register_page_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginRegisterScreen.this,LoginScreen.class);
            }
        });
    }
}
