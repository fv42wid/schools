package com.example.school.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class SchoolCommand {

    private Long id;
    @NotBlank(message = "School name is required")
    private String name;
    @NotBlank(message = "Start date is required")
    private String startDate;
    @NotBlank(message = "End Date is required")
    private String endDate;
    private String degree;
}
