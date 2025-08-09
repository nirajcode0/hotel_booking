package com.hotel_booking.Exception;

import com.hotel_booking.DTO.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFound(NoUserFoundException ex, HttpServletRequest request) {
        ErrorResponseDto response = new ErrorResponseDto("404", ex.getMessage(), List.of(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationErrors(MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponseDto response = new ErrorResponseDto(
                "400",
                "Validation failed",
                errors,
                request.getRequestURI()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponseDto> anyException(Exception ex, HttpServletRequest request)
//    {
//        ErrorResponseDto response = new ErrorResponseDto("404", ex.getMessage(), List.of(), request.getRequestURI());
//        return  new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
//    }



}
