package com.mouracleston.cbredcharapi.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ProblemDetail notFound404(EntityNotFoundException e) {
        var detail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        detail.setTitle("Entidade não encontrada");
        detail.setDetail("A entidade não pode ser encontrada no banco de dados");
        detail.setProperty("Categoria", "Plataforma");
        detail.setProperty("TimeStamp", Instant.now());
        return detail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail badRequest400(MethodArgumentNotValidException e) {
        var detail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        detail.setTitle("Conteúdo inválido");
        detail.setDetail("O conteúdo envidado não é compativel com a API");
        detail.setProperty("Categoria", "Plataforma");
        detail.setProperty("TimeStamp", Instant.now());
        return detail;
    }

}
