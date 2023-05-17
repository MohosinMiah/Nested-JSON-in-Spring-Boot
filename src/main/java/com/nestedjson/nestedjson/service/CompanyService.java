package com.nestedjson.nestedjson.service;

import com.nestedjson.nestedjson.dto.CompanyDTO;
import com.nestedjson.nestedjson.second.OrderRequest;

import jakarta.validation.Valid;

public interface CompanyService {
    CompanyDTO createCompany(CompanyDTO companyDTO);

    OrderRequest createOrder(@Valid OrderRequest orderRequest);
}

