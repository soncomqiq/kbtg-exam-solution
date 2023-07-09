package tech.kbtg.exams_solution.exception;

public class ExceptionPayload
{
	private String message;
	private int    status;

	public ExceptionPayload()
	{
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus( int status )
	{
		this.status = status;
	}
}
