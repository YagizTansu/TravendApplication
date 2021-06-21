package com.example.travend;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username ;
    EditText password ;

    private Button signup;
    private Button login;

    //Alttaki yapı sayesinde buttonlara bütün viewlara farklı işlevler atayabiliyoruz
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                Intent sIntent = new Intent(getApplicationContext(), SignupActivity.class);
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

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        signup = findViewById(R.id.button2);
        signup.setOnClickListener(this);
        login = findViewById(R.id.button);
        login.setOnClickListener(this);


    }

}