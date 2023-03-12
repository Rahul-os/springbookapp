package books.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {  
	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<Object> exception(BookNotFoundException ex){
		return new ResponseEntity<Object>("book not available",HttpStatus.NOT_FOUND);
	}
	

}
