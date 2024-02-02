package com.pedropaulino.creditapplicationsystem.service.impl

import com.pedropaulino.creditapplicationsystem.entity.Customer
import com.pedropaulino.creditapplicationsystem.repository.CustomerRepository
import com.pedropaulino.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {

    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


    override fun findById(customerID: Long): Customer =
        this.customerRepository.findById(customerID).orElseThrow {
            throw RuntimeException("Id $customerID not found")
        }

    override fun delete(customerID: Long) = this.customerRepository.deleteById(customerID)

}