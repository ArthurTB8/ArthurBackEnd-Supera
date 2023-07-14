package br.com.banco.controllers;
import br.com.banco.exceptions.InvalidDateException;
import br.com.banco.exceptions.NullFilterException;
import br.com.banco.exceptions.ObjectNotFoundException;
import br.com.banco.exceptions.StandardError;
import br.com.banco.utils.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<StandardError>> handleBeanValidationException(MethodArgumentNotValidException ex) {
        List<StandardError> errorList = ex.getAllErrors()
                .stream()
                .map(this::convertObjectErrorToStandardError)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorList);
    }

    private StandardError convertObjectErrorToStandardError(ObjectError objectError) {
        return new StandardError(
                objectError.getDefaultMessage(),
                DateUtils.convertSystemTimeMillisToString(System.currentTimeMillis()),
                HttpStatus.NOT_ACCEPTABLE.value()
        );
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> handleNotFound(ObjectNotFoundException ex) {
        StandardError error = createStandardError(ex.getMessage(), HttpStatus.NOT_FOUND);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NullFilterException.class)
    public ResponseEntity<StandardError> handleNullFilter(NullFilterException ex) {
        StandardError error = createStandardError(ex.getMessage(), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<StandardError> handleInvalidDate(InvalidDateException ex) {
        StandardError error = createStandardError(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
    }

    private StandardError createStandardError(String message, HttpStatus httpStatus) {
        return new StandardError(
                message,
                DateUtils.convertSystemTimeMillisToString(System.currentTimeMillis()),
                httpStatus.value()
        );
    }
}
