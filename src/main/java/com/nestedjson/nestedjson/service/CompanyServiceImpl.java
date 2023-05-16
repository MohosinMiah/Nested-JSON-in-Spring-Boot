package com.nestedjson.nestedjson.service;

import org.springframework.stereotype.Service;

import com.nestedjson.nestedjson.dto.CompanyDTO;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        // Perform any additional business logic or processing here
        // e.g., saving the company to a database, calling other services, etc.

        // For this example, we will simply return the received DTO
        return companyDTO;
    }

 
}
