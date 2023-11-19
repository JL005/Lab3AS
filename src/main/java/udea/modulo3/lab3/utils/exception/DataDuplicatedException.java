package udea.modulo3.lab3.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataDuplicatedException extends RuntimeException{

    public DataDuplicatedException(String message) {
        super(message);
    }
}
