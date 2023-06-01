package com.alura.forum.domain.infra.exception;

import com.alura.forum.domain.modelo.exception.UsuarioEmUsoException;
import jakarta.persistence.EntityNotFoundException;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ProblemDetails> handleEntityNotFoundException(EntityNotFoundException e, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setType("Usuário não encontrado");
        problemDetails.setTitle("Não encontrado");
        problemDetails.setStatus(HttpStatus.NOT_FOUND.value());
        problemDetails.setTimestamp(LocalDateTime.now());
        problemDetails.setDetail(e.getMessage());
        problemDetails.setInstance(request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetails);
    }

    @ExceptionHandler(UsuarioEmUsoException.class)
    public ResponseEntity<ProblemDetails> handleUsuarioEmUsoException(UsuarioEmUsoException e, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setType("Usuário já existe");
        problemDetails.setTitle("Conflito");
        problemDetails.setTimestamp(LocalDateTime.now());
        problemDetails.setStatus(HttpStatus.CONFLICT.value());
        problemDetails.setDetail(e.getMessage());
        problemDetails.setInstance(request.getDescription(false));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(problemDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetails> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request, HttpHeaders headers,
                                                                       HttpStatus status) {
        List<ValidationErrorDetails> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(ValidationErrorDetails::fromFieldError)
                .collect(Collectors.toList());
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setType("Argumento inválido");
        problemDetails.setTitle("Bad Request");
        problemDetails.setTimestamp(LocalDateTime.now());
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setDetail("Falha na validação");
        problemDetails.setInstance(request.getDescription(false));
        problemDetails.setErrors(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetails);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ProblemDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException e, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setType("about:blank");
        problemDetails.setTitle("Bad Request");
        problemDetails.setTimestamp(LocalDateTime.now());
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setDetail(e.getMessage());
        problemDetails.setInstance(request.getDescription(false));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetails);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetails> handleGenericException(Exception e, WebRequest request) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setType("Erro genérico");
        problemDetails.setTitle("Internal Server Error");
        problemDetails.setTimestamp(LocalDateTime.now());
        problemDetails.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        problemDetails.setDetail("Entre em contato com o administrador.");
        problemDetails.setInstance(request.getDescription(false));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetails);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ProblemDetails> handleConstraintViolationException(ConstraintViolationException e,
                                                                             WebRequest request) {
        List<ValidationErrorDetails> errors = e.getConstraintViolations()
                .stream()
                .map(ValidationErrorDetails::fromConstraintViolation)
                .collect(Collectors.toList());

        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setType("Violação de contrato");
        problemDetails.setTitle("Bad Request");
        problemDetails.setTimestamp(LocalDateTime.now());
        problemDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        problemDetails.setDetail("Falha na validação");
        problemDetails.setInstance(request.getDescription(false));
        problemDetails.setErrors(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problemDetails);
    }


}
