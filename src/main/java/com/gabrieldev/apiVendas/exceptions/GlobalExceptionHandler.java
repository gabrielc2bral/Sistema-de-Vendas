package com.gabrieldev.apiVendas.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private StandardError buildError(HttpStatus httpStatus, String error, String message, HttpServletRequest request){
        return new StandardError(
                Instant.now(),
                httpStatus.value(),
                error,
                message,
                request.getRequestURI()
        );
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> handleNotFound(EntityNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Entidade não existe";

        StandardError err = buildError(status, error, e.getMessage(), request);

        return ResponseEntity.status(status).body(err);
    }

    // Aprendendo esse novo padrão de exception
    @ExceptionHandler(InvalidLoginException.class)
    public ResponseEntity<StandardError> invalidLogin(InvalidLoginException e, HttpServletRequest request) {
        String error = "Erro de autenticação";
        HttpStatus status = HttpStatus.UNAUTHORIZED;

        StandardError err = buildError(status, error, e.getMessage(), request);

        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(EstoqueInsuficienteException.class)
    public ResponseEntity<StandardError> estoqueInsuficiente(EstoqueInsuficienteException e, HttpServletRequest request) {
        String error = "Estoque Insuficiente";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError err = buildError(status, error, e.getMessage(), request);

        return ResponseEntity.status(status).body(err);
    }
}
