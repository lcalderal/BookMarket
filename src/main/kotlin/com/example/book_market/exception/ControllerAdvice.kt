package com.example.book_market.exception

import com.example.book_market.controller.response.ErrorResponse
import com.example.book_market.controller.response.FieldErrorResponse
import com.example.book_market.enums.Errors
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(exception: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.NOT_FOUND.value(),
            message = exception.message,
            internalCode = exception.errorCode,
            errors = null
        )

        return ResponseEntity(error, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.BAD_REQUEST.value(),
            message = exception.message,
            internalCode = exception.errorCode,
            errors = null
        )

        return ResponseEntity(error, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException,
        request: WebRequest
    ): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(
            httpCode = HttpStatus.UNPROCESSABLE_ENTITY.value(),
            message = Errors.BM001.message,
            internalCode = Errors.BM001.code,
            errors = exception.bindingResult.fieldErrors.map {
                FieldErrorResponse(message = it.defaultMessage ?: "Invalid", field = it.field)
            }
        )

        return ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY)
    }
}