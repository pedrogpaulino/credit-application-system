package com.pedropaulino.creditapplicationsystem.service

import com.pedropaulino.creditapplicationsystem.entity.Credit
import org.springframework.stereotype.Service
import java.util.UUID


interface ICreditService {

    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long,creditCode: UUID): Credit

}