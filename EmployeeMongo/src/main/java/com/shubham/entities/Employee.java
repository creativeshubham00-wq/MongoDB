package com.shubham.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "employee")
public class Employee {

    @Id
    private String id;

    private String name;

    @Field(name = "email_address")
    private String email;

    @DBRef
    private Company company;

    @DBRef
    private List<Project> projects;

    @Transient
    private double averageRating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public double getAverageRating() {
        if (projects != null && !projects.isEmpty()) {
            int total = 0;
            for (Project project : projects) {
                total += project.getRating();
            }
            return (double) total / projects.size();
        }
        return 0.0;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}