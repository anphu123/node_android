package com.example.node_android;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<User> mListUsers;
    private EditText txtMail;
    private EditText txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText txtMail = (EditText) findViewById(R.id.editTextEmail);
        EditText txtPass = (EditText) findViewById(R.id.editTextPassword);
        ImageButton loginButton = (ImageButton) findViewById(R.id.submit_button1);
        ImageButton submitButton = (ImageButton) findViewById(R.id.submit_button2);

        getListUsers();
        mListUsers = new ArrayList<>();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, home.class));

            }
        });

    }

    private void checkLogin() {
        String strUsername = txtMail.getText().toString().trim();
        String strPass = txtPass.getText().toString().trim();

        if (mListUsers == null || mListUsers.isEmpty()) {
            return;
        }


    }

    private void getListUsers(){
        ApiService.apiService.getListUsers()
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        mListUsers = response.body();
                        Log.e("ListUsers",mListUsers.size()+"");
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"goi api that bai !!",Toast.LENGTH_LONG).show();
                    }
                });
    }
}