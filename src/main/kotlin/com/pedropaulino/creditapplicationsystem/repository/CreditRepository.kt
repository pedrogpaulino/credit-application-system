package com.pedropaulino.creditapplicationsystem.repository

import com.pedropaulino.creditapplicationsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit, Long> {

    fun findByCreditCode(creditCode: UUID): Credit?

    @Query(value= "SELECT * FROM CREDIT WHERE CUSTOMER_ID = ?1", nativeQuery = true )
        fun findAllByCustomer(customerId: Long): List<Credit>
}