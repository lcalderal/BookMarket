package com.example.book_market

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan("com.example.book_market.model")
class BookMarketApplication

fun main(args: Array<String>) {
	runApplication<BookMarketApplication>(*args)
}
