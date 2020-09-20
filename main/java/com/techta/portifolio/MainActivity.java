package com.techta.portifolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Button mProjectsBtn, authorBtn;
    private Animation buttonClick;
    private FadingTextView fadingTextView;
    private RelativeLayout mainView;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.mainNavView);
        navigationView.setNavigationItemSelectedListener(this);

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_contact:
                String mailto = "mailto:nikoladuranovic@gmail.com" +
                        "?cc=" + "" +
                        "&subject=" + Uri.encode("Dev Contact") +
                        "&body=" + Uri.encode("");

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(mailto));

                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.menu_repository:
                String url = "https://github.com/purity6666";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));

                startActivity(i);
                return true;

            default:
                return false;
        }
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