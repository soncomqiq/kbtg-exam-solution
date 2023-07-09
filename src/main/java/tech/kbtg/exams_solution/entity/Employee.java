package tech.kbtg.exams_solution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "employees" )
public class Employee
{
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY )
	@Column ( name = "id" )
	private int id;

	@Column ( name = "first_name" )
	private String firstName;

	@Column ( name = "last_name" )
	private String lastName;

	@Column ( name = "nick_name" )
	private String nickName;

	@Column ( name = "salary" )
	private Float salary;

	@Column ( name = "status" )
	private StatusEnum status;

	@Column ( name = "address" )
	private String address;

	@Column ( name = "position" )
	private String position;

	public Employee()
	{
	}

	public Employee( String firstName , String lastName , Float salary , StatusEnum status , String address , String position )
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.status = status;
		this.address = address;
		this.position = position;
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

	public Float getSalary()
	{
		return salary;
	}

	public void setSalary( Float salary )
	{
		this.salary = salary;
	}

	public StatusEnum getStatus()
	{
		return status;
	}

	public void setStatus( StatusEnum status )
	{
		this.status = status;
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

	public String getNickName()
	{
		return nickName;
	}

	public void setNickName( String nickName )
	{
		this.nickName = nickName;
	}
}
