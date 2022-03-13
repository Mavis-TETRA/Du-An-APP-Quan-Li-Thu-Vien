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

public class SignInAdmin extends AppCompatActivity {
    private EditText SG_inputUsrenameAdmin, SG_inputPassAdmin;
    private ImageView ivEye;
    private boolean isOpenEye = false;
    private Button btn_SignAdmin;
    private TextView btn_backLoginAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_admin);

        btn_SignAdmin = (Button) findViewById(R.id.btn_SignAdmin);
        btn_backLoginAdmin = (TextView) findViewById(R.id.btn_backLoginAdmin);

        SG_inputUsrenameAdmin = (EditText) findViewById(R.id.SG_inputUsrenameAdmin);
        SG_inputPassAdmin = (EditText) findViewById(R.id.SG_inputPasswordAdmin);

        ivEye = (ImageView) findViewById(R.id.iv_eye);

        //=================================================================
        //Phần Xử lí chạm chuyển activity
        btn_SignAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, password;
                username = String.valueOf(SG_inputUsrenameAdmin.getText());
                password = String.valueOf(SG_inputPassAdmin.getText());

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
                            PutData putData = new PutData("http://192.168.1.9/CDVienDongLibary/LoginAndSignUp/signupadmin.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignInAdmin.this, LoginAdmin.class);
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

        btn_backLoginAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInAdmin.this, LoginAdmin.class);
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
                    SG_inputPassAdmin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    ivEye.setSelected(false);
                    isOpenEye = false;
                    //Password not visible
                    SG_inputPassAdmin.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        //==========================================================
    }
}
