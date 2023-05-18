package com.nestedjson.nestedjson.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nestedjson.nestedjson.entity.BaseOrder;
import com.nestedjson.nestedjson.entity.BillingAddress;
import com.nestedjson.nestedjson.entity.Customer;
import com.nestedjson.nestedjson.entity.OrderDetail;
import com.nestedjson.nestedjson.entity.Orders;
import com.nestedjson.nestedjson.entity.PaymentMethod;
import com.nestedjson.nestedjson.firstpayload.CompanyDTO;
import com.nestedjson.nestedjson.payload.BaseOrderDto;
import com.nestedjson.nestedjson.payload.OrderDetailDto;
import com.nestedjson.nestedjson.repository.BaseOrderRepository;
import com.nestedjson.nestedjson.repository.BillingAddressRepository;
import com.nestedjson.nestedjson.repository.CustomerRepository;
import com.nestedjson.nestedjson.repository.OrderDetailRepository;
import com.nestedjson.nestedjson.repository.OrdersRepository;
import com.nestedjson.nestedjson.repository.PaymentMethodRepository;
import com.nestedjson.nestedjson.service.CompanyService;

import java.util.List;

import org.modelmapper.ModelMapper;

import jakarta.validation.Valid;

@Service
public class CompanyServiceImpl implements CompanyService {


    @Autowired
    private BaseOrderRepository baseOrderRepository;

    @Autowired
    private BillingAddressRepository billingAddressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ModelMapper mapper;

   

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        // Perform any additional business logic or processing here
        // e.g., saving the company to a database, calling other services, etc.

        // For this example, we will simply return the received DTO
        return companyDTO;
    }

    @Override
    public BaseOrderDto createOrder(@Valid BaseOrderDto baseOrderDto) {
        // TODO Auto-generated method stub

        // Save Base Order Date 
        BaseOrder baseOrder = new BaseOrder();
        baseOrder.setTransactionId(baseOrderDto.getTransactionId());
        baseOrder.setAmount(baseOrderDto.getAmount());
        baseOrder.setCurrency(baseOrderDto.getCurrency());
        baseOrderRepository.save(baseOrder);

        // Save Customer Data
        Customer customer = new Customer();
        customer.setId(baseOrderDto.getCustomer().getId());
        customer.setName(baseOrderDto.getCustomer().getName());
        customer.setEmail(baseOrderDto.getCustomer().getEmail());
        customerRepository.save(customer);
        customerRepository.save(customer);

        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setCustomerid(baseOrderDto.getPaymentMethod().getCustomerid());
        paymentMethod.setType(baseOrderDto.getPaymentMethod().getType());
        paymentMethod.setCardNumber(baseOrderDto.getPaymentMethod().getCardNumber());
        paymentMethod.setExpirationMonth(baseOrderDto.getPaymentMethod().getExpirationMonth());
        paymentMethod.setExpirationYear(baseOrderDto.getPaymentMethod().getExpirationYear());
        paymentMethod.setCvv(baseOrderDto.getPaymentMethod().getCvv());
        paymentMethod.setBillindaddressid(baseOrderDto.getPaymentMethod().getBillindaddressid());
        paymentMethodRepository.save(paymentMethod);

        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setBillindaddressid(baseOrderDto.getPaymentMethod().getBillingAddress().getBillindaddressid());
        billingAddress.setStreet(baseOrderDto.getPaymentMethod().getBillingAddress().getStreet());
        billingAddress.setCity(baseOrderDto.getPaymentMethod().getBillingAddress().getCity());
        billingAddress.setState(baseOrderDto.getPaymentMethod().getBillingAddress().getState());
        billingAddress.setZip(baseOrderDto.getPaymentMethod().getBillingAddress().getZip());
        billingAddressRepository.save(billingAddress);


        Orders orders = new Orders();
        orders.setOrderid(baseOrderDto.getOrders().getOrderid());
        orders.setCustomerid(baseOrderDto.getOrders().getCustomerid());
        orders.setOrderdate(baseOrderDto.getOrders().getOrderdate());
        ordersRepository.save(orders);


        

        List<OrderDetailDto> orderDetailDto = baseOrderDto.getOrderdetails();

        for (OrderDetailDto order : orderDetailDto) {

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderdetailsid(order.getOrderdetailsid());
            orderDetail.setOrderid(order.getOrderid());
            orderDetail.setProductid(order.getProductid());
            orderDetail.setPrice(order.getPrice());
            orderDetail.setQuantity(order.getQuantity());
            orderDetailRepository.save(orderDetail);
        }

        System.out.println(baseOrderDto.getCustomer());
        return baseOrderDto;
    }

 
}
