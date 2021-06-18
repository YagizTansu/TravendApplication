package com.example.travend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

    }
    public void onSignupBtnClick(View view) {
        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        TextView password = findViewById(R.id.password);
        TextView rePassword = findViewById(R.id.rePassword);
        TextView gender = findViewById(R.id.gender);
        View birthDate = findViewById(R.id.birthDate);
        TextView about = findViewById(R.id.about);

        //Burda yanlıs anlamadıysam bilgileri tutuyoruz aldığımız. Yaptığımız user arraylistine
        //bu bilgileri gönderebiliriz direkt

        Intent Intent = new Intent(this, MainActivity.class);
        startActivity(Intent);
    }


}
