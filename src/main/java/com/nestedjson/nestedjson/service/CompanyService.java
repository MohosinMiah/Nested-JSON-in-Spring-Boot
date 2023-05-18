package com.nestedjson.nestedjson.service;

import com.nestedjson.nestedjson.firstpayload.CompanyDTO;
import com.nestedjson.nestedjson.payload.BaseOrderDto;

import jakarta.validation.Valid;

public interface CompanyService {
    CompanyDTO createCompany(CompanyDTO companyDTO);

    BaseOrderDto createOrder(@Valid BaseOrderDto orderRequest);
}

