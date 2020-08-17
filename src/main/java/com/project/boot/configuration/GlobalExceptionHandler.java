package com.project.boot.configuration;

import com.project.boot.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorDto handleApiException(Exception ex) {
        return new ErrorDto(400, ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = {EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorDto handleApiException(EntityNotFoundException ex) {
        return new ErrorDto(404, ex.getMessage());
    }

}
