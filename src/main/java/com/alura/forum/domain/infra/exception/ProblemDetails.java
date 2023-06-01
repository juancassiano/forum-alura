package com.alura.forum.domain.infra.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {
    private String type;
    private LocalDateTime timestamp;
    private String title;
    private Integer status;
    private String detail;
    private String instance;
    private List<ValidationErrorDetails> errors;
}
