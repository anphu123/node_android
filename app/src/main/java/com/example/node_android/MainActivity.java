package com.example.node_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText txtMail;
    private EditText txtPass;
    private ImageButton loginButton;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = ApiClient.getApiClient().create(ApiService.class);

        txtMail = findViewById(R.id.editTextEmail);
        txtPass = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.submit_button1);
        ImageButton submitButton = findViewById(R.id.submit_button2);

        login1();

//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkLogin();
//            }
//        });
//
//        submitButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Handle other button clicks or remove this listener if not needed
//            }
//        });
    }

    private void login1() {

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                String username = txtMail.getText().toString().trim();
                String password = txtPass.getText().toString().trim();
                user.setName(username);
                user.setPasswd(password);
                apiService.login(user).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful()) {
                            // Login successful, navigate to home or do whatever needed
                            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, home.class));
                        } else {
                            // Login failed
                            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        // API call failed, handle error
                        Toast.makeText(MainActivity.this, "Login failed. Please try again later.", Toast.LENGTH_SHORT).show();
                        Log.e("Login Error", "Failed to login", t); // Log the error for debugging
                    }
                });
            }
        });
    }
}
