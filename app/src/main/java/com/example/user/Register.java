package com.example.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private TextView registerUser;
    private EditText editTextFullName, editTextUserName, editTextBirthdate,
            editTextCountry, editTextCity, editTextPw, editTextConfirmPw, editTextEmail;
    private RadioButton radioStudent , radioSponsor;
//    private ProgressBar progressBar;

//    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        mAuth = FirebaseAuth.getInstance();

        registerUser = (Button) findViewById(R.id.register_btn);
        registerUser.setOnClickListener(this);

        editTextFullName = (EditText)findViewById(R.id.fullname);
        editTextUserName = (EditText)findViewById(R.id.username);
        editTextBirthdate = (EditText)findViewById(R.id.editTextDate);
        editTextCountry = (EditText)findViewById(R.id.editTextCountry);
        editTextCity = (EditText)findViewById(R.id.editTextCity);
        editTextPw = (EditText)findViewById(R.id.input_Password);
        editTextConfirmPw = (EditText)findViewById(R.id.confirm_Password);
        editTextEmail = (EditText)findViewById(R.id.input_Email);

        radioStudent= (RadioButton)findViewById(R.id.student_radio_btn);
        radioSponsor = (RadioButton)findViewById(R.id.sponsor_radio_btn);

//        progressBar = (ProgressBar)findViewById(R.id.progressBar2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.register_btn:
                registerUser();
                break;
        }

    }
    private void registerUser(){
          String fullname = editTextFullName.getText().toString().trim();
          String username = editTextUserName.getText().toString().trim();
         String birthday = editTextBirthdate.getText().toString().trim();
         String country = editTextCountry.getText().toString().trim();
        String city = editTextCity.getText().toString().trim();
        String password = editTextPw.getText().toString().trim();
        String Cpassword = editTextConfirmPw.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String Student = radioStudent.getText().toString().trim();
        String Sponsor = radioSponsor.getText().toString().trim();

        if (fullname.isEmpty()){
            editTextFullName.setError("Full name is required");
            editTextFullName.requestFocus();
            return;
        }
        if (username.isEmpty()){
            editTextUserName.setError("User name is required");
            editTextUserName.requestFocus();
            return;
        }
        if (birthday.isEmpty()){
            editTextBirthdate.setError("Birth date is required");
            editTextBirthdate.requestFocus();
            return;
        }
        if (country.isEmpty()){
            editTextCountry.setError("Country name is required");
            editTextCountry.requestFocus();
            return;
        }
        if (city.isEmpty()){
            editTextCity.setError("City name is required");
            editTextCity.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editTextPw.setError("Password is required");
            editTextPw.requestFocus();
            return;
        }
        if (Cpassword.isEmpty()){
            editTextConfirmPw.setError("Country name is required");
            editTextConfirmPw.requestFocus();
            return;
        }
        if (email.isEmpty()){
            editTextEmail.setError("Country name is required");
            editTextEmail.requestFocus();
            return;
        }
        if(!radioStudent.isChecked() && !radioSponsor.isChecked()) {
            radioStudent.setError("Choose at least one criteria ");
            radioStudent.requestFocus();
            return;
        }

//        progressBar.setVisibility(View.VISIBLE);
//        mAuth.createUserWithEmailAndPassword(email,password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()){
//                            User user = new User(fullname,username,email,birthday,country,city);
//
//                            FirebaseDatabase.getInstance().getReference("Users")
//                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()
//                                    ).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//
//                                    if (task.isSuccessful()){
//                                        Toast.makeText(Register.this, "User has been registered successfully!", Toast.LENGTH_LONG).show();
////                                        ProgressBar.setVisibility(View.VISIBLE);
//                                    }else
//                                        Toast.makeText(Register.this, "Failed to register, Try again!", Toast.LENGTH_LONG).show();
////                                    ProgressBar.setVisibility(View.GONE);
//                                }
//                            });
//                        }else {
//                            Toast.makeText(Register.this, "Failed to register!", Toast.LENGTH_LONG).show();
////                            ProgressBar.setVisibility(View.GONE);
//
//
//                        }
//                    }
//                });
    }

}