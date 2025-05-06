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

}
