package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class EnterValidDataException extends  Exception{
        public EnterValidDataException(String exception){
            super(exception);
        }

}
