package com.example.travend;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;


public class SignupActivity extends AppCompatActivity {

    EditText textName ;
    EditText textEmail ;
    EditText textPassword ;
    EditText rePassword ;
    EditText textGender ;
    EditText textBirthdate;
    EditText textAbout ;
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

         textName = findViewById(R.id.name);
         textEmail = findViewById(R.id.email);
         textPassword = findViewById(R.id.password);
         rePassword = findViewById(R.id.rePassword);
         textGender = findViewById(R.id.gender);
         textBirthdate = findViewById(R.id.birthDate);
         textAbout = findViewById(R.id.about);
         buttonSignUp =findViewById(R.id.buttonSignUp);

         buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username , email , password , gender,birthday,about;

                username = String.valueOf(textName.getText());
                email = String.valueOf(textEmail.getText());
                password = String.valueOf(textPassword.getText());
                gender = String.valueOf(textGender.getText());
                birthday = String.valueOf(textBirthdate.getText());
                about = String.valueOf(textAbout.getText());

                System.out.println(username);

                if (!username.equals("") && !email.equals("")&& !password.equals("") && !gender.equals("") && !birthday.equals("")){
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[6];
                            field[0] = "username";
                            field[1] = "email";
                            field[2] = "password";
                            field[3] = "gender";
                            field[4] = "birthday";
                            field[5] = "about";
                            //Creating array for data
                            String[] data = new String[6];

                            data[0] = username;
                            data[1] = email;
                            data[2] = password;
                            data[3] = gender;
                            data[4] = birthday;
                            data[5] = about;

                            PutData putData = new PutData("https://192.168.1.4/Travend/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_SHORT).show();
                                        Intent Intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(Intent);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                        System.out.println(result);
                                    }
                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(),"All fields are required",Toast.LENGTH_SHORT).show();
                }
                //Burda yanlıs anlamadıysam bilgileri tutuyoruz aldığımız. Yaptığımız user arraylistine
                //bu bilgileri gönderebiliriz direkt
            }
        });
    }
}
