package com.example.patterns_banking.services;

import com.example.patterns_banking.dtos.CustomerDTO;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.services.proxy.ICustomerOperations;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  private final ICustomerOperations customerOperations;

  public CustomerService(ICustomerOperations customerOperations) {
    this.customerOperations = customerOperations;
  }

  public Customer create(CustomerDTO customerDTO) {
    // Implementar proxy para verificar que el correo no sea del dominio yahoo
    return customerOperations.create(customerDTO);
  }
}
