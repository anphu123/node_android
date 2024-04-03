package com.example.node_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText txtMail;
    private EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMail = findViewById(R.id.editTextEmail);
        txtPass = findViewById(R.id.editTextPassword);
        ImageButton loginButton = findViewById(R.id.submit_button1);
        ImageButton submitButton = findViewById(R.id.submit_button2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Home.class));
            }
        });
    }

    private void checkLogin() {
        String strUsername = txtMail.getText().toString().trim();
        String strPass = txtPass.getText().toString().trim();

        // Thực hiện validation
        if (strUsername.isEmpty() || strPass.isEmpty()) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập cả tên đăng nhập và mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }

        // Thực hiện kiểm tra đăng nhập
        // Ở đây bạn có thể thêm logic kiểm tra đăng nhập dựa trên thông tin từ EditText
        // Ví dụ: so sánh với giá trị mặc định hoặc gọi API kiểm tra đăng nhập

        // Ví dụ đơn giản: so sánh với giá trị mặc định
        if (strUsername.equals("admin") && strPass.equals("admin123")) {
            // Đăng nhập thành công
            Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, home.class));
        } else {
            // Đăng nhập không thành công
            Toast.makeText(MainActivity.this, "Tên đăng nhập hoặc mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
        }
    }
}
