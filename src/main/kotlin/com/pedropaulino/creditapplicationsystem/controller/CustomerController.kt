package com.pedropaulino.creditapplicationsystem.controller

import com.pedropaulino.creditapplicationsystem.dto.CustomerDto
import com.pedropaulino.creditapplicationsystem.service.impl.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController (
        private val customerService: CustomerService
) {

    @PostMapping
    fun saveCustomer(@RequestBody customerDto : CustomerDto) : String{
        val savedCustomer = this.customerService.save(customerDto.toEntity())

    return "Customer ${savedCustomer.email} saved!"
    }

}