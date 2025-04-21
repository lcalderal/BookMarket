package com.example.book_market.controller.response

import com.example.book_market.enums.BookStatus
import com.example.book_market.model.CustomerModel
import java.math.BigDecimal

data class BookResponse(
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    var customer: CustomerModel? = null,
    var status: BookStatus? = null
)
