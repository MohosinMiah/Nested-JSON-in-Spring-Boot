package com.nestedjson.nestedjson.firstpayload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
 
    @NotEmpty(message = "Employee first name must requred")
    private String firstName;

    @NotEmpty(message = "Employee last name must requred")
    private String lastName;

    private int age;

    private double salary;

    @NotEmpty
    private String designation;

    @NotEmpty
    private String contactNumber;

    @NotEmpty
    @Email(message = "Employee Email Must Required")
    private String emailId;
 
}