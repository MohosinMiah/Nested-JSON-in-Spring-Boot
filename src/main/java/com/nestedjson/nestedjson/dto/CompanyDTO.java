package com.nestedjson.nestedjson.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
 
    @NotEmpty
    private String companyName;

    @NotEmpty(message = "Nested POJO Root companyEmailId required")
    private String companyEmailId;

    @NotEmpty(message = "Nested POJO Root companyNumber required")
    private String companyNumber;

    @NotEmpty(message = "Nested POJO Root companyAddress required")
    private String companyAddress;

    @NotEmpty(message = "Nested POJO Root supportedSalaryBanks required")
    private List<String> supportedSalaryBanks;

    @Valid
    @NotNull
    private EmployeeDTO employee;

    @Valid
    @NotNull
    private ContractorsDTO contractors;

    @Valid
    @NotNull
    private CompanyPFDetailsDTO companyPFDetails;

}