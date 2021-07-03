package pl.pjatk.jazs21164nbp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GatewayTimeoutException extends RuntimeException{
    @ExceptionHandler(GatewayTimeoutException.class)
    public ResponseEntity<Object> handlerRuntimeException(GatewayTimeoutException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.GATEWAY_TIMEOUT);
    }
}
