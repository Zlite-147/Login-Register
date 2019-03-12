package com.example.zlite_147.loginlearncodeonline;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import io.rmiri.buttonloading.ButtonLoading;


public class MainActivity extends AppCompatActivity {


    TextView txt_sign;

    ButtonLoading  buttonLoading;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLoading=(ButtonLoading)findViewById(R.id.btn_loading);
        progressBar=(ProgressBar)findViewById(R.id.progrss_bar);

        txt_sign=(TextView)findViewById(R.id.txt_signUp);
        txt_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }
        });

        buttonLoading.setOnButtonLoadingListener(new ButtonLoading.OnButtonLoadingListener() {
            @Override
            public void onClick() {
                progressBar.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        buttonLoading.setProgress(false);
                        startActivity(new Intent(MainActivity.this,Main2Activity.class));
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

