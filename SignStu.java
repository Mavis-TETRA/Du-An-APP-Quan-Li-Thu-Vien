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

public class SignInStu extends AppCompatActivity {
    private EditText SG_inputUsrename, SG_inputPass;
    private ImageView ivEye;
    private boolean isOpenEye = false;
    private Button btn_SignStu;
    private TextView btn_backLoginStu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_stu);

        btn_SignStu = (Button) findViewById(R.id.btn_SignStu);
        btn_backLoginStu = (TextView) findViewById(R.id.btn_backLoginStu);

        SG_inputUsrename = (EditText) findViewById(R.id.SG_inputUsrename);
        SG_inputPass = (EditText) findViewById(R.id.SG_inputPassword);

        ivEye = (ImageView) findViewById(R.id.iv_eye);

        //=================================================================
        //Phần Xử lí chạm chuyển activity
        btn_SignStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mssv, password;
                mssv = String.valueOf(SG_inputUsrename.getText());
                password = String.valueOf(SG_inputPass.getText());

                if (!mssv.equals("") && !password.equals("")){

                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] field = new String[2];
                            field[0] = "mssv";
                            field[1] = "password";

                            String[] data = new String[2];
                            data[0] = mssv;
                            data[1] = password;
                            PutData putData = new PutData("http://192.168.1.9/CDVienDongLibary/LoginAndSignUp/signupstu.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignInStu.this, Login.class);
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

        btn_backLoginStu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInStu.this, Login.class);
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
                    SG_inputPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    ivEye.setSelected(false);
                    isOpenEye = false;
                    //Password not visible
                    SG_inputPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        //==========================================================
    }
}
