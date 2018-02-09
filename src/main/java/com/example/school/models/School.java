package com.example.school.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String startDate;
    private String endDate;
    private String degree;
    private Date createdAt;

    @ManyToOne
    private User user;
}
