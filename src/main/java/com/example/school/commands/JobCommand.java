package com.example.school.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class JobCommand {

    private Long id;
    @NotBlank(message = "Company name is required")
    private String company;
    @NotBlank(message = "Position is required")
    private String position;
    @NotBlank(message = "Start date is required")
    private String startDate;
    @NotBlank(message = "End date is required")
    private String endDate;
}
