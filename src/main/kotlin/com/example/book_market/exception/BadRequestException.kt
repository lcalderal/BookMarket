package com.example.book_market.exception

class BadRequestException(override val message: String, val errorCode: String) : Exception() {
}