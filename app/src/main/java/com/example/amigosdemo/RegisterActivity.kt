package com.example.amigosdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.VisibleForTesting
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    EditText emailET, passET,confirm_pass;
    Button register_btn, login_btn;
    Checkbox checkBox;
    ProgressBar progressBar;
    FirebaseAuth mAuth;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        emailEt = findViewById(R.id.register_email_et)
        passET = findViewById(R.id.register_password_et)
        confirm_pass = findViewById(R.id.register_confirmpassword_et)
        register_btn = findViewById(R.id.signup_to_login)
        checkBox = findViewById(R.id.register_checkbox)
        progressBar = findViewById(R.id.progressbar_register)
        mAuth = FirebaseAuth.getInstance()

        checkBox.setOnCheckedChangeListener(new CompoundButton . OnCheckedChangeListener) {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {

                    passEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
                    confirm_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance())

                } else {

                    passEt.setTransformationMethod(PasswordTransformationMethod.getInstance())
                    confirm_pass.setTransformationMethod(PasswordTransformationMethod.getInstance())


                }
            }
        }
        register_btn.setOnClicklistener(new View.OnClickKistener())
        @Override
        public void onCLick(View View) {

            String email = emailEt.getText().toString();
            String pass = passEt.getText().toString();
            String confirm_password = confirm_pass.getText().toString()

            if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(pass) || !TextUtils.isEmpty(confirm_pass)){

                if(pass.equals(confirm_password)){
                    progressBar.setVisibility(View.VISIBLE)

                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>){
                        @Override
                        public void OnComplete(@NonNull Task<AuthResult> task) {

                        }

                    }



                }else {
                    Toast.makeText(RegisterActivity.this, "password and confirm password is not matching")

                }
            } else {
                Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

    }
    }