package hello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by W28L30 on 2016/10/18.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such post")
public class PostNotFoundException extends RuntimeException {
}
