package com.pedropaulino.creditapplicationsystem.controller

import com.pedropaulino.creditapplicationsystem.dto.CreditDto
import com.pedropaulino.creditapplicationsystem.dto.CreditViewList
import com.pedropaulino.creditapplicationsystem.entity.Credit
import com.pedropaulino.creditapplicationsystem.service.impl.CreditService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

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

    @GetMapping
    fun findAllByCustomerId (@RequestParam(value ="customerId") customerId: Long): List<CreditViewList>{
        return this.creditService.findAllByCustomer(customerId).stream().map { credit: Credit -> CreditViewList(credit)}.collect(Collectors.toList())
    }

}