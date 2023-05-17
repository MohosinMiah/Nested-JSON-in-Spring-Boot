package com.nestedjson.nestedjson.second;

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
public class OrderRequest {
    @NotEmpty(message = "Transaction ID is requirede")
    private String transactionId;

    @NotNull(message = "Order amount is required")
    private Double amount;

    @NotEmpty(message = "Order Currency is required")
    private String currency;

    @Valid
    @NotNull
    private Customer customer;

    @Valid
    @NotNull
    private PaymentMethod paymentMethod;

    @Valid
    @NotNull
    private Orders orders;

    @Valid
    @NotNull
    private List<OrderDetail> orderdetails;

}