package com.pedropaulino.creditapplicationsystem.controller

import com.pedropaulino.creditapplicationsystem.dto.CustomerDto
import com.pedropaulino.creditapplicationsystem.dto.CustomerUpdateDto
import com.pedropaulino.creditapplicationsystem.dto.CustomerView
import com.pedropaulino.creditapplicationsystem.entity.Customer
import com.pedropaulino.creditapplicationsystem.service.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
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

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : CustomerView {
        val customer: Customer = this.customerService.findById(id)

        return CustomerView(customer)
    }

    @DeleteMapping("/id")
    fun deleteById(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateById(@RequestParam(value = "customerId") id: Long,
                   @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView{

        val customer: Customer= this.customerService.findById(id)
        val customerToUpdate = customerUpdateDto.toEntity(customer)

        val customerUpdated: Customer = this.customerService.save(customerToUpdate)

        return CustomerView(customerUpdated)
    }

}