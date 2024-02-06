package com.pedropaulino.creditapplicationsystem.controller

import com.pedropaulino.creditapplicationsystem.dto.CreditDto
import com.pedropaulino.creditapplicationsystem.entity.Credit
import com.pedropaulino.creditapplicationsystem.service.impl.CreditService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/credits")
class CreditController(
        private val creditService: CreditService
){

    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto) : String{
    val credit: Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${credit.creditCode} - Customer ${credit.customer?.firstName} saved!"
    }

}