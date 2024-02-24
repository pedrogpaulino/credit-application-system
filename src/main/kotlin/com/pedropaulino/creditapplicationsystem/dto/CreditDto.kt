package com.pedropaulino.creditapplicationsystem.dto

import com.pedropaulino.creditapplicationsystem.entity.Credit
import com.pedropaulino.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.*
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
        @field:NotNull(message = "Informe um valor!")
        @field:Positive(message = "Valor negativo ou zero!")
        val creditValue: BigDecimal,

        @field:Future(message ="O dia da primeira parcela não deve ser anterior a data de hoje!" )
        val dayFirstInstallment: LocalDate,

        @field:NotNull(message = "Informe um valor!")
        @field:Positive(message = "Valor negativo ou zero!")
        //@field:Size(min = 1, max = 8, message = "O crédito deve haver no mínimo {min} parcelas e no máximo {max} parcelas")
        @field:Min(value = 1, message = "O número de parcelas deve ser no mínimo 1")
        @field:Max(value = 8, message = "O número de parcelas deve ser no máximo 48")
        val numberOfInstallments: Int,

        @field:NotNull(message = "Informe um ID!")
        @field:Positive(message = "Não aceito ID negativo!")
        val customerId: Long
) {
    fun toEntity(): Credit = Credit(
            creditValue = this.creditValue,
            dayFirstInstallment = this.dayFirstInstallment,
            numberOfInstallments = this.numberOfInstallments,
            customer = Customer(id = this.customerId)
    )
}
