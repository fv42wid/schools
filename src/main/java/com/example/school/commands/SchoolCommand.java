package com.example.school.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SchoolCommand {

    private Long id;
    private String name;
    private String startDate;
    private String endDate;
    private String degree;
}
