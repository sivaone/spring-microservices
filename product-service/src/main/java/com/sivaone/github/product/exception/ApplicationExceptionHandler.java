package com.sivaone.github.product.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleEntityNotFoundException(
            ProductNotFoundException ex, ServletWebRequest webRequest) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto("ERR-100", "Product not found");
        ErrorResponseDto response = ErrorResponseDto.builder()
                .path(webRequest.getRequest().getRequestURL().toString())
                .errors(List.of(errorMessageDto))
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(Exception ex) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto("ERR-500", "Unknown error");
        ErrorResponseDto response = ErrorResponseDto.builder()
                .path("")
                .errors(List.of(errorMessageDto))
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}


@Builder
@Getter
class ErrorResponseDto {
    private String path;
    private List<ErrorMessageDto> errors;
    private LocalDateTime timestamp;
}

@AllArgsConstructor
@Getter
class ErrorMessageDto {
    private String code;
    private String message;
}
