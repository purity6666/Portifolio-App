package com.techta.portifolio;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProjectRecyclerViewAdapter extends RecyclerView.Adapter<ProjectRecyclerViewAdapter.ViewHolder>{

    private ArrayList<Project> projects = new ArrayList<>();
    private Context context;
    private Animation animation;

    @NonNull
    @Override
    public ProjectRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_format, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProjectRecyclerViewAdapter.ViewHolder holder, final int position) {
        holder.projectName.setText(projects.get(position).getProjectName());
        holder.shortDesc.setText(projects.get(position).getShortDesc());
        holder.projectCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation = AnimationUtils.loadAnimation(context, R.anim.zoom_out);
                holder.projectCV.startAnimation(animation);
                switch (projects.get(position).getProjectName()) {
                    case "Cube":
                        openLink("https://github.com/purity6666/CubeApp", view);
                        break;
                    case "Genero":
                        openLink("https://github.com/purity6666/GeneroAutomaticVersion", view);
                        break;
                }
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(projects.get(position).getImageURL())
                .into(holder.projectImage);
    }

    private void openLink(String url, View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));

        view.getContext().startActivity(i);
    }


    @Override
    public int getItemCount() {
        return projects.size();
    }

    public ProjectRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView projectName, shortDesc;
        private CardView projectCV;
        private ImageView projectImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            projectName = itemView.findViewById(R.id.projectName);
            shortDesc = itemView.findViewById(R.id.projectDesc);
            projectCV = itemView.findViewById(R.id.projectFormat);
            projectImage = itemView.findViewById(R.id.projectImage);
        }
    }
}
