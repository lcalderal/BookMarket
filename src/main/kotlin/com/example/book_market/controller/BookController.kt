package com.example.book_market.controller

import com.example.book_market.controller.request.PostBookRequest
import com.example.book_market.controller.request.PutBookRequest
import com.example.book_market.controller.response.BookResponse
import com.example.book_market.extension.toBookModel
import com.example.book_market.extension.toBookResponse
import com.example.book_market.service.BookService
import com.example.book_market.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    fun createBook(@RequestBody request: PostBookRequest) {
        val customerId = customerService.getCustomerById(request.customerId)
        bookService.createBook(request.toBookModel(customerId))
    }

    @GetMapping
    fun getAllBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.getAllBooks(pageable).map { it.toBookResponse() }
    }

    @GetMapping("/active")
    fun getActiveBooks(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.getActiveBooks(pageable).map { it.toBookResponse() }
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Int) = bookService.getBookById(id).toBookResponse()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: Int) {
        bookService.deleteBook(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateBook(@PathVariable id: Int, @RequestBody request: PutBookRequest) {
        val bookSaved = bookService.getBookById(id)
        bookService.updateBook(request.toBookModel(bookSaved))
    }
}