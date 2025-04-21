package com.example.book_market.controller.request

import com.example.book_market.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest(
    @field:NotEmpty(message = "Name cannot be empty")
    val name: String,

    @field:Email(message = "Invalid email format")
    @EmailAvailable(message = "Email is already in use")
    val email: String
)
