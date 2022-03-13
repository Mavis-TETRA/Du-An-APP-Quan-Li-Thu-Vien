package com.example.libaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class LoginAdmin extends AppCompatActivity {
    private EditText LG_inputUsrenameAdmin, LG_inputPassAdmin;
    private ImageView ivEye;
    private boolean isOpenEye = false;
    private Button btn_LoginAdmin;
    private TextView btn_loginStudent, btn_forgetpassAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        btn_LoginAdmin = (Button) findViewById(R.id.btn_LoginAdmin);
        btn_forgetpassAdmin = (TextView) findViewById(R.id.btn_ForgotPassAdmin);
        btn_loginStudent = (TextView) findViewById(R.id.btn_LoginStudent);

        LG_inputUsrenameAdmin = (EditText) findViewById(R.id.LG_inputUsrenameAdmin);
        LG_inputPassAdmin = (EditText) findViewById(R.id.LG_inputPasswordAdmin);

        ivEye = (ImageView) findViewById(R.id.iv_eye);

        //=================================================================
        //Phần Xử lí chạm chuyển activity
        btn_LoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, password;
                username = String.valueOf(LG_inputUsrenameAdmin.getText());
                password = String.valueOf(LG_inputPassAdmin.getText());

                if (!username.equals("") && !password.equals("")){

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                            PutData putData = new PutData("http://192.168.1.9/CDVienDongLibary/LoginAndSignUp/loginadmin.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginAdmin.this, MenuAdmin.class);
                                        startActivity(intent);
                                        finish();
                                    }else{
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        }
                    });
                }else {
                    Toast.makeText(getApplicationContext(), "All Fields Required", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_forgetpassAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginAdmin.this, SignInAdmin.class);
                startActivity(intent);
            }
        });

        btn_loginStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginAdmin.this, Login.class);
                startActivity(intent);
            }
        });
        //========================================================

        //========================================================
        //Phần Làm ẩn hiện password
        ivEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpenEye) {
                    ivEye.setSelected(true);
                    isOpenEye = true;
                    //Password visible
                    LG_inputPassAdmin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    ivEye.setSelected(false);
                    isOpenEye = false;
                    //Password not visible
                    LG_inputPassAdmin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        //==========================================================
    }
}
