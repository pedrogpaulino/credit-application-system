package com.pedropaulino.creditapplicationsystem.entity

import com.pedropaulino.creditapplicationsystem.enummeration.Status
import jakarta.persistence.*
import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "Credit")
data class Credit (
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) var numberOfInstallments: Int = 0,
    @Enumerated var status: Status = Status.IN_PROGRESS,
    @ManyToOne var customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)
