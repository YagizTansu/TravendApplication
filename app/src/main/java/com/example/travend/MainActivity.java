package com.example.travend;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button signup;
    private Button login;

    //Alttaki yapı sayesinde buttonlara bütün viewlara farklı işlevler atayabiliyoruz
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                Intent sIntent = new Intent(this, SignupActivity.class);
                startActivity(sIntent);
                break;
            case R.id.button:
                Intent lIntent = new Intent(this, tabActivity.class);
                startActivity(lIntent);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = findViewById(R.id.button2);
        signup.setOnClickListener(this);
        login = findViewById(R.id.button);
        login.setOnClickListener(this);

    }


    public void onSignupBtnClick(View view) {
        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        TextView password = findViewById(R.id.password);
        TextView rePassword = findViewById(R.id.rePassword);
        TextView gender = findViewById(R.id.gender);
        View birthDate = findViewById(R.id.birthDate);
        TextView about = findViewById(R.id.about);

    }


}