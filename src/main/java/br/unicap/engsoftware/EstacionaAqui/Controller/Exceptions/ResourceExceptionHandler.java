package br.unicap.engsoftware.EstacionaAqui.Controller.Exceptions;

import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.FullParkingLotException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.InvalidParkingSpotQuantityException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceAlreadyExistsException;
import br.unicap.engsoftware.EstacionaAqui.Service.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<StandardError> resourceAlreadyExists(ResourceAlreadyExistsException exception, HttpServletRequest request) {
        String error = "Resource already exists";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidParkingSpotQuantityException.class)
    public ResponseEntity<StandardError> invalidParkingSpotQuantity(InvalidParkingSpotQuantityException exception, HttpServletRequest request) {
        String error = "Invalid parking spot quantity";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(FullParkingLotException.class)
    public ResponseEntity<StandardError> fullParkingLot(FullParkingLotException exception, HttpServletRequest request) {
        String error = "There are no more parking spaces";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpServletRequest request) {
        String error = "Invalid argument";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
