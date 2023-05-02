package com.fin.fintechbookstore.exceptions.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fin.fintechbookstore.exceptions.CustomException;
import com.fin.fintechbookstore.exceptions.RepositoryException;
import com.fin.fintechbookstore.exceptions.ServiceException;
import com.fin.fintechbookstore.model.responses.ErrorResponse;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class ControllersAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ErrorResponse> JsonProcessingHandler(JsonProcessingException ce) {

        ErrorResponse errorResponse = new ErrorResponse(ce.getClass().getSimpleName() + " : " + ce.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HibernateException.class)
    public ResponseEntity<ErrorResponse> hibernateHandler(HibernateException ce) {

        ErrorResponse errorResponse = new ErrorResponse(ce.getClass().getSimpleName() + " : " + ce.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> serviceHandler(CustomException ce) {

        ErrorResponse errorResponse = new ErrorResponse(ce.getClass().getSimpleName() + " : " + ce.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customeHandler(CustomException ce) {

        ErrorResponse errorResponse = new ErrorResponse(ce.getClass().getSimpleName() + " : " + ce.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.LOCKED);
    }

    @ExceptionHandler(RepositoryException.class)
    public ResponseEntity<ErrorResponse> repoHandler(CustomException ce) {

        ErrorResponse errorResponse = new ErrorResponse(ce.getClass().getSimpleName() + " : " + ce.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorResponse> sqlHandler(SQLException ce) {

        ErrorResponse errorResponse = new ErrorResponse(ce.getClass().getSimpleName() + " : " + ce.getMessage());

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}
