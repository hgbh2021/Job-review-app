package com.example.rest_api.job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job() {
    }

    public Job(Long id, String title, String minSalary, String maxSalary, String location, String description) {
        this.id = id;
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.title = title;
        this.description = description;
    }
}
