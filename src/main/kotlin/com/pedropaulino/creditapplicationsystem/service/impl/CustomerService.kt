package com.pedropaulino.creditapplicationsystem.service.impl

import com.pedropaulino.creditapplicationsystem.entity.Customer
import com.pedropaulino.creditapplicationsystem.exception.BusinessException
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
            throw BusinessException("Id $customerID not found")
        }

    override fun delete(customerID: Long){
        val customer: Customer = this.findById(customerID)
        this.customerRepository.delete(customer)
    }
}