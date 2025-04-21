package com.example.book_market.service

import com.example.book_market.enums.CustomerStatus
import com.example.book_market.model.CustomerModel
import com.example.book_market.repository.CustomerRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository,
    val bookService: BookService
    ) {

    fun getAll(name: String?, pageable: Pageable): Page<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(name, pageable)
        }
        return customerRepository.findAll(pageable)
    }

    fun getCustomerById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun createCustomer(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun updateCustomer(customer: CustomerModel) {
        if (customerRepository.existsById(customer.id!!).not()) throw Exception()

        customerRepository.save(customer)
    }

    fun deleteCustomer(id: Int) {
        val customer = getCustomerById(id)
        bookService.deleteByCustomerId(customer)

        customer.status = CustomerStatus.INATIVO
        customerRepository.save(customer)
    }
}