package tech.kbtg.exams_solution.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionControllerHandler
{
	@ExceptionHandler
	public ResponseEntity < ExceptionPayload > handleNotFoundException( ResourceNotFoundException ex )
	{
		ExceptionPayload payload = new ExceptionPayload();

		payload.setStatus( HttpStatus.NOT_FOUND.value() );
		payload.setMessage( ex.getMessage() );

		return ResponseEntity.status( HttpStatus.NOT_FOUND ).body( payload );
	}

	@ExceptionHandler
	public ResponseEntity < ExceptionPayload > handleNumberFormatException( NumberFormatException ex )
	{
		ExceptionPayload payload = new ExceptionPayload();

		payload.setStatus( HttpStatus.BAD_REQUEST.value() );
		payload.setMessage( ex.getMessage() );

		return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( payload );
	}

	@ExceptionHandler
	public ResponseEntity < ExceptionPayload > handleNumberFormatException( BadFormatException ex )
	{
		ExceptionPayload payload = new ExceptionPayload();

		payload.setStatus( HttpStatus.BAD_REQUEST.value() );
		payload.setMessage( ex.getMessage() );

		return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( payload );
	}

}
