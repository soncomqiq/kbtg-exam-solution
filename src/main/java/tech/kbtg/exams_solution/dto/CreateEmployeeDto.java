package tech.kbtg.exams_solution.dto;

public class CreateEmployeeDto
{
	private String firstName;
	private String lastName;
	private String nickName;
	private String address;
	private Float  salary;
	private String position;

	public CreateEmployeeDto()
	{
	}

	public CreateEmployeeDto( String firstName , String lastName , String nickName , Float salary , String address , String position )
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.salary = salary;
		this.address = address;
		this.position = position;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName( String nickName )
	{
		this.nickName = nickName;
	}

	public Float getSalary()
	{
		return salary;
	}

	public void setSalary( Float salary )
	{
		this.salary = salary;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition( String position )
	{
		this.position = position;
	}
}
