package com.gabrieldev.apiVendas.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    // Aprendendo esse novo padrão de exception
    @ExceptionHandler(InvalidLoginException.class)
    public ResponseEntity<StandardError> invalidLogin(InvalidLoginException e, HttpServletRequest request) {
        String error = "Erro de autenticação";
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        StandardError err = new StandardError(
                Instant.now(),
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(EstoqueInsuficienteException.class)
    public ResponseEntity<StandardError> estoqueInsuficiente(EstoqueInsuficienteException e, HttpServletRequest request) {
        String error = "Estoque Insuficiente";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = new StandardError(
                Instant.now(),
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(err);
    }
}
