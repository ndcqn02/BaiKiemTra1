package com.example.baikiemtra1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {
    EditText edt_Email, edt_Password;
    Button btnSignin;
    CheckBox cbRemenber;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        edt_Email = findViewById(R.id.edt_Email);
        edt_Password = findViewById( R.id.edt_Password);
        cbRemenber = findViewById(R.id.cbRemeber);
        btnSignin = findViewById(R.id.btnSignIn);

        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);
        // lấy giá trị từ sharePreferences
        edt_Email.setText(sharedPreferences.getString("user",""));
        edt_Password.setText(sharedPreferences.getString("pass",""));
        cbRemenber.setChecked(sharedPreferences.getBoolean("checked",false));


        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_Email.getText().toString().trim();
                String password = edt_Password.getText().toString().trim();

                if(username.equals("admin") && password.equals("123")){
                    Toast.makeText( SigninActivity.this, "Login successfull",Toast.LENGTH_SHORT).show();

                    //if mà tick vào nhớ
                    if(cbRemenber.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("user", username);
                        editor.putString("pass",password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("user");
                        editor.remove("pass");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else {
                    Toast.makeText( SigninActivity.this, "Erorr",Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}