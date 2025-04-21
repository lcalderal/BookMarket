package com.example.book_market.model

import com.example.book_market.enums.CustomerStatus
import jakarta.persistence.*

@Entity(name = "customer")
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String = "",

    @Column
    var email: String = "",

    @Column
    @Enumerated(EnumType.STRING)
    var status: CustomerStatus = CustomerStatus.ATIVO
)
