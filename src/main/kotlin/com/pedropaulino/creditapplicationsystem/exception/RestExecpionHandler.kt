package com.pedropaulino.creditapplicationsystem.exception

import org.aspectj.apache.bcel.classfile.Field
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDateTime

@RestControllerAdvice
class RestExecpionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException): ResponseEntity<ExceptionDetails>{
        val erros: MutableMap<String,String?> = HashMap()
        ex.bindingResult.allErrors.stream().forEach{
            erro: ObjectError ->
            val fieldName: String = (erro as FieldError).field
            val messageErro: String? = erro.defaultMessage
            erros[fieldName] = messageErro
        }
        return ResponseEntity(
                ExceptionDetails(
                        title = "Bad request, consult the documentation",
                        timestamp = LocalDateTime.now(),
                        status = HttpStatus.BAD_REQUEST.value(),
                        exception = ex.javaClass.toString(),
                        details = erros
                ),HttpStatus.BAD_REQUEST
        )
    }


    @ExceptionHandler(DataAccessException::class)
    fun handlerValidException(ex: DataAccessException): ResponseEntity<ExceptionDetails>{
        return ResponseEntity(
                ExceptionDetails(
                        title = "Conflit, consult the documentation",
                        timestamp = LocalDateTime.now(),
                        status = HttpStatus.BAD_REQUEST.value(),
                        exception = ex.javaClass.toString(),
                        details = mutableMapOf(ex.cause.toString() to ex.message)
                ),HttpStatus.CONFLICT
        )
    }
}