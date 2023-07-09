package tech.kbtg.exams_solution.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateEmployeeDto
{
	private int    id;
	private String firstName;
	private String lastName;
	private String nickName;
	private String address;
	private Float  percent;

	@JsonProperty ( "current_position" )
	private String currentPos;
	@JsonProperty ( "new_position" )
	private String newPos;

	public UpdateEmployeeDto()
	{
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
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

	public String getAddress()
	{
		return address;
	}

	public void setAddress( String address )
	{
		this.address = address;
	}

	public Float getPercent()
	{
		return percent;
	}

	public void setPercent( Float percent )
	{
		this.percent = percent;
	}

	public String getCurrentPos()
	{
		return currentPos;
	}

	public void setCurrentPos( String currentPos )
	{
		this.currentPos = currentPos;
	}

	public String getNewPos()
	{
		return newPos;
	}

	public void setNewPos( String newPos )
	{
		this.newPos = newPos;
	}
}

