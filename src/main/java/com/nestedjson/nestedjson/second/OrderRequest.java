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
    @NotNull(message = "Customer Info can not empty")
    private Customer customer;

    @Valid
    @NotNull(message = "Payment Method can not be emopty")
    private PaymentMethod paymentMethod;

    @Valid
    @NotNull(message = "Orders Info can not be empty")
    private Orders orders;

    @Valid
    @NotNull(message = "Order Details can not be Empty")
    private List<OrderDetail> orderdetails;

}