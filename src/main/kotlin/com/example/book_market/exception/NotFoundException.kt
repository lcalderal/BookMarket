package com.example.book_market.exception

class NotFoundException(override val message: String, val errorCode: String) : Exception() {
}