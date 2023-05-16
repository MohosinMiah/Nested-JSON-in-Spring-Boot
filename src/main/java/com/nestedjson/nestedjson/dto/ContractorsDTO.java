package com.nestedjson.nestedjson.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractorsDTO {
 
    // private variables or data members of pojo class
    
    @NotEmpty(message = "Contractor first name must requred")
    private String firstName;

    @NotEmpty(message = "Contractor last name must requred")
    private String lastName;

    @NotEmpty(message = "Contractor contractFrom  must requred")
    private String contractFrom;

    @NotEmpty(message = "Contractor contractTo  must requred")
    private String contractTo;

    @NotEmpty(message = "Contractor contactNumber  must requred")
    private String contactNumber;

 
  
}
 