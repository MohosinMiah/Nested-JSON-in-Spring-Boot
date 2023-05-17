package com.nestedjson.nestedjson.second;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @NotEmpty(message = "Customer ID is required")
    private String id;

    @NotEmpty(message = "Customer name is required")
    private String name;

    @NotEmpty(message = "Customer email is required")
    private String email;
}
