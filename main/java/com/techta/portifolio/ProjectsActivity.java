package com.techta.portifolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;

import java.util.ArrayList;

public class ProjectsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        recyclerView = findViewById(R.id.projectsRecyclerView);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#000000\">" + "Projects" + "</font>"));

        ArrayList<Project> projects = new ArrayList<>();

        projects.add(new Project("Cube", "Small app, first app that used custom animations", "https://cdn.discordapp.com/attachments/627815799268311060/746685136497541250/20200822_125956.jpg"));
        projects.add(new Project("Genero","6-digit number generator that sends you notification every time a new number has been generated","https://cdn.discordapp.com/attachments/737325870615625842/757632638860263485/Screenshot_20200921-180028_Genero.jpg"));
        projects.add(new Project("Fart App","App that produces fart noise when the poop button is pressed","https://cdn.discordapp.com/attachments/757696925578297504/757697474595913768/Screenshot_20200918-121954_Fart_App.jpg"));
        projects.add(new Project("Dialer","App that dials the entered phone number","https://cdn.discordapp.com/attachments/757696925578297504/757982050023112714/Screenshot_20200922-170850_Dialer.jpg"));
        projects.add(new Project("Calculator","Very simple calculator app","https://cdn.discordapp.com/attachments/757696925578297504/757982049385840640/Screenshot_20200922-170925_Calculator.jpg"));
        projects.add(new Project("Binary Converter","App that converts regular text into binary","https://cdn.discordapp.com/attachments/757696925578297504/757982048727203890/Screenshot_20200922-170937_binary_converter.jpg"));

        ProjectRecyclerViewAdapter adapter = new ProjectRecyclerViewAdapter(this);
        adapter.setProjects(projects);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}