package tech.kbtg.exams_solution.exception;

public class ResourceNotFoundException extends RuntimeException
{
	public ResourceNotFoundException( String message )
	{
		super( message );
	}

	public ResourceNotFoundException()
	{
	}
}
