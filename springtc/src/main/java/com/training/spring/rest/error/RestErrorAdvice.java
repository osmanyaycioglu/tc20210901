package com.training.spring.rest.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return new ErrorObj().setMsg(exp.getMessage())
                             .setCause(100);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        ErrorObj rootError = new ErrorObj().setMsg("Validation error")
                                           .setCause(200);
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(new ErrorObj().setMsg(objectErrorLoc.toString())
                                                .setCause(201));
        }
        return rootError;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(final Exception exp) {
        return new ErrorObj().setMsg(exp.getMessage())
                             .setCause(500);
    }

}
