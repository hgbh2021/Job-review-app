package com.example.rest_api.job;

import lombok.Data;

@Data
public class Job {
    private Long id;
    private String title;
    private String Description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job( Long id, String title, String minSalary, String maxSalary, String location, String description) {
        this.id = id;
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.title = title;
        Description = description;
    }
}
