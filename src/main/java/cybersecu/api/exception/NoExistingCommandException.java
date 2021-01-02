package cybersecu.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoExistingCommandException extends Exception {

    public NoExistingCommandException() {
        super();
    }

    public NoExistingCommandException(String msg) {
        super(msg);
    }
}
