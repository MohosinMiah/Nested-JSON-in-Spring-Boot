package com.nestedjson.nestedjson.firstpayload;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CompanyPFDetailsDTO {
 
    @NotEmpty(message = " CompanyPFDetails pfName name must requred")
    private String pfName;

    private int pfYear;

    private int noOfEmployees;
 
 
}




  