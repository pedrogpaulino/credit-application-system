package com.pedropaulino.creditapplicationsystem.service

import com.pedropaulino.creditapplicationsystem.entity.Customer

interface ICustomerInterface {

    fun save(customer: Customer): Customer

    fun findById(customerID: Long): Customer

    fun delete(customerID: Long): Customer
}