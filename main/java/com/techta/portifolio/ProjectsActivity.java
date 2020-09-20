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

        projects.add(new Project("Test Project", "Test Test Test", "https://cdn.discordapp.com/attachments/627815799268311060/755892917058404503/unknown.png"));
        projects.add(new Project("Cube", "Small app, first app that used custom animations", "https://cdn.discordapp.com/attachments/627815799268311060/746685136497541250/20200822_125956.jpg"));

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