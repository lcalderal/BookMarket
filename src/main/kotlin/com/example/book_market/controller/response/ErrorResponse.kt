package com.example.book_market.controller.response

data class ErrorResponse(
    val httpCode: Int,
    val message: String,
    val internalCode: String,
    val errors: List<FieldErrorResponse>? = null
)
