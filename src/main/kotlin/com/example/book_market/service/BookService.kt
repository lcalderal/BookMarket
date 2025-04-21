package com.example.book_market.service

import com.example.book_market.enums.BookStatus
import com.example.book_market.model.BookModel
import com.example.book_market.model.CustomerModel
import com.example.book_market.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {

    fun createBook(book: BookModel) {
        bookRepository.save(book)
    }

    fun getAllBooks(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun getActiveBooks(pageable: Pageable): Page<BookModel> {
        return bookRepository.getBookByStatus(BookStatus.ATIVO, pageable)
    }

    fun getBookById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun deleteBook(id: Int) {
        val book = getBookById(id)
        book.status = BookStatus.CANCELADO
        updateBook(book)
    }

    fun updateBook(book: BookModel) {
        bookRepository.save(book)
    }

    fun deleteByCustomerId(customer: CustomerModel) {
       val bookList = bookRepository.findByCustomer(customer)
        bookList.forEach { book ->
            book.status = BookStatus.DELETADO
        }
        bookRepository.saveAll(bookList)
    }
}
