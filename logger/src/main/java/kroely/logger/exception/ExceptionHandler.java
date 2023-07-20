package kroely.logger.exception;

import org.springframework.http.HttpStatus;

public class ExceptionHandler extends RuntimeException{
    HttpStatus status;

    public ExceptionHandler(String message) {
        super(message);
    }

    public ExceptionHandler(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpStatus getStatus() {
        return status;
    }
}