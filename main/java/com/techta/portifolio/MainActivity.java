package com.techta.portifolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mProjectsBtn, authorBtn;
    private Animation buttonClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClick = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        mProjectsBtn = findViewById(R.id.projectsBtn);
        authorBtn = findViewById(R.id.authorBtn);

        getSupportActionBar().setElevation(0);

        mProjectsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivity();
            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(this, ProjectsActivity.class);
        startActivity(intent);
    }
}