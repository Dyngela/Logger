package kroely.logger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class APIExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ExceptionHandler.class})
    public ResponseEntity<Object> handleAPIRequestException(ExceptionHandler e) {

        if (e.getStatus() != null) {
            APIException exception = new APIException(
                    e.getMessage(),
                    e.status,
                    ZonedDateTime.now(ZoneId.of("Z"))
            );
            return new ResponseEntity<>(exception, e.status);
        } else {
            APIException exception = new APIException(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST,
                    ZonedDateTime.now(ZoneId.of("Z"))
            );
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);

        }
    }
}