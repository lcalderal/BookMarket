package com.example.book_market.controller.request

import java.math.BigDecimal

data class PutBookRequest(
    val name: String?,
    val price: BigDecimal?
)
