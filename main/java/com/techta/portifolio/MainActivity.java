package com.techta.portifolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;
import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {

    private Button mProjectsBtn, authorBtn;
    private Animation buttonClick;
    private FadingTextView fadingTextView;
    private RelativeLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainView = findViewById(R.id.firstPageLayout);

        fadingTextView = findViewById(R.id.firstPageTxt);
        buttonClick = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
        mProjectsBtn = findViewById(R.id.projectsBtn);
        authorBtn = findViewById(R.id.authorBtn);

        fadingTextView.setTimeout(5, FadingTextView.SECONDS);



        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#000000\">" + getString(R.string.app_name) + "</font>"));

        mProjectsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mProjectsBtn.startAnimation(buttonClick);
                openActivity();
            }
        });

        authorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authorBtn.startAnimation(buttonClick);
                showSnackbar();
            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(this, ProjectsActivity.class);
        startActivity(intent);
    }

    private void showSnackbar() {
        Snackbar.make(mainView, "The author of this app is Nikola Đuranović", Snackbar.LENGTH_INDEFINITE)
                .setAction("Continue", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {}
                })
                .setActionTextColor(Color.parseColor("#808080"))
                .setTextColor(getResources().getColor(R.color.black))
                .setBackgroundTint(ContextCompat.getColor(this, R.color.white))
                .show();
    }
}