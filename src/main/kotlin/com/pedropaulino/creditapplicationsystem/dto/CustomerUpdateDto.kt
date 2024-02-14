package com.pedropaulino.creditapplicationsystem.dto

import com.pedropaulino.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.NegativeOrZero
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class CustomerUpdateDto(
        @field:NotEmpty(message = "Informe um nome!")
        val firstName: String,

        @field:NotEmpty(message = "Informe o ultimo nome!")
        val lastName: String,

        @field:NotNull(message = "Informe um valor!")
        @field:Positive(message = "Valor negativo ou zero!")
        val income: BigDecimal,

        @field:NotEmpty(message = "Informe um CEP!")
        val zipCode: String,

        @field:NotEmpty(message = "Informe uma rua!!")
        val street: String,
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street

        return customer
    }
}
