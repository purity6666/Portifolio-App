package com.techta.portifolio;

public class Project {
    private String projectName;
    private String shortDesc;
    private String imageURL;

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public Project(String projectName, String shortDesc, String imageURL) {
        this.projectName = projectName;
        this.shortDesc = shortDesc;
        this.imageURL = imageURL;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
