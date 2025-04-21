package com.example.book_market.controller.response

import com.example.book_market.enums.CustomerStatus

data class CustomerResponse(
    var id: Int?,
    var name: String,
    var email: String,
    var status: CustomerStatus
)
