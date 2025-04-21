package com.example.book_market.controller.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PutCustomerRequest(
    @field:NotEmpty(message = "Name cannot be empty")
    var name: String,

    @field:Email(message = "Invalid email format")
    var email: String
)
