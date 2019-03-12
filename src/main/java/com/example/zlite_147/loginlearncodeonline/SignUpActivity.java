package com.example.zlite_147.loginlearncodeonline;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import io.rmiri.buttonloading.ButtonLoading;

public class SignUpActivity extends AppCompatActivity {


    ButtonLoading buttonLoading;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        buttonLoading=(ButtonLoading)findViewById(R.id.btn_loading);
        progressBar=(ProgressBar)findViewById(R.id.progrss_bar);

        buttonLoading=(ButtonLoading)findViewById(R.id.btn_loading_register);

        buttonLoading.setOnButtonLoadingListener(new ButtonLoading.OnButtonLoadingListener() {
            @Override
            public void onClick() {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SignUpActivity.this, "Register Success", Toast.LENGTH_SHORT).show();
                        buttonLoading.setProgress(false);
                        startActivity(new Intent(SignUpActivity.this,MainActivity.class));
                    }
                },5000);
            }

            @Override
            public void onStart() {
                //...

            }

            @Override
            public void onFinish() {
                //...
                progressBar.setVisibility(View.GONE);

            }

        });

    }
}
