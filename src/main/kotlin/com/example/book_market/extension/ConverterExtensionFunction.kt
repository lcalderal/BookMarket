package com.example.book_market.extension

import com.example.book_market.controller.request.PostBookRequest
import com.example.book_market.controller.request.PostCustomerRequest
import com.example.book_market.controller.request.PutBookRequest
import com.example.book_market.controller.request.PutCustomerRequest
import com.example.book_market.controller.response.BookResponse
import com.example.book_market.enums.BookStatus
import com.example.book_market.enums.CustomerStatus
import com.example.book_market.model.BookModel
import com.example.book_market.model.CustomerModel
import com.example.book_market.controller.response.CustomerResponse

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email, status = CustomerStatus.ATIVO)
}

fun PutCustomerRequest.toCustomerModel(customer: CustomerModel): CustomerModel {
    return CustomerModel(id = customer.id, name = this.name, email = this.email, status = customer.status)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(bookModel: BookModel): BookModel {
    return BookModel(
        id = bookModel.id,
        name = this.name ?: bookModel.name,
        price = this.price ?: bookModel.price,
        status = bookModel.status,
        customer = bookModel.customer
    )
}

fun CustomerModel.toCustomerResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toBookResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        price = this.price,
        status = this.status,
        customer = this.customer
    )
}