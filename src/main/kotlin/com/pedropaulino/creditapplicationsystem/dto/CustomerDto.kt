package com.pedropaulino.creditapplicationsystem.dto

import com.pedropaulino.creditapplicationsystem.entity.Address
import com.pedropaulino.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.*
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
        @field:NotEmpty(message = "Informe um nome!")
        val firstName: String,

        @field:NotEmpty(message = "Informe o ultimo nome!")
        val lastName: String,

        @field:NotEmpty(message = "CPF não deve estar vazio!")
        @field:CPF(message = "CPF inválido!")
        val cpf: String,

        @field:NotNull(message = "Informe um valor!")
        @field:Positive(message = "Valor negativo ou zero!")
        val income: BigDecimal,

        @field:NotEmpty(message = "Informe um e-email!")
        @field:Email(message = "Email inválido, deve seguir o padrão 'email@email.com'")
        val email: String,

        @field:NotEmpty(message = "Informe uma senha!")
        val password: String,

        @field:NotEmpty(message = "Informe um CEP!")
        val zipcode: String,

        @field:NotEmpty(message = "Informe uma rua!!")
        val street: String,
) {
    fun toEntity(): Customer = Customer(
            firstName = this.firstName,
            lastName = this.lastName,
            cpf = this.cpf,
            income = this.income,
            email = this.email,
            password= this.password,
            address = Address(
                    zipCode = this.zipcode,
                    street = this.street
            )
    )
}
