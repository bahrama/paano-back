package ir.tehranluster.paano.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
@ResponseStatus(value = HttpStatus.NOT_FOUND , reason = "user not found")
public class UserNotFoundException extends EntityNotFoundException {

   public UserNotFoundException(String message) {
      super(message);
   }
}
