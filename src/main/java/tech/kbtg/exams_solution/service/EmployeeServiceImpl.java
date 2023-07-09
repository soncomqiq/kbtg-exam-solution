package tech.kbtg.exams_solution.service;

import org.springframework.stereotype.Service;
import tech.kbtg.exams_solution.dto.CreateEmployeeDto;
import tech.kbtg.exams_solution.dto.UpdateEmployeeDto;
import tech.kbtg.exams_solution.entity.Employee;
import tech.kbtg.exams_solution.entity.StatusEnum;
import tech.kbtg.exams_solution.exception.BadFormatException;
import tech.kbtg.exams_solution.exception.ResourceNotFoundException;
import tech.kbtg.exams_solution.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	private EmployeeRepository employeeRepository;

	private final String NOT_FOUND_MESSAGE = "Not found employee ID: ";

	public EmployeeServiceImpl( EmployeeRepository employeeRepository )
	{
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List < Employee > getAllEmployees()
	{
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById( Integer id )
	{
		Optional < Employee > result = employeeRepository.findById( id );
		if ( result.isPresent() )
		{
			return result.get();
		}
		throw new ResourceNotFoundException( NOT_FOUND_MESSAGE + id );
	}

	@Override
	public Employee createEmployee( CreateEmployeeDto employeeDto )
	{
		Employee newEmployee = new Employee();

		newEmployee.setFirstName( employeeDto.getFirstName() );
		newEmployee.setLastName( employeeDto.getLastName() );
		newEmployee.setNickName( employeeDto.getNickName() );
		newEmployee.setSalary( employeeDto.getSalary() );
		newEmployee.setPosition( employeeDto.getPosition() );
		newEmployee.setAddress( employeeDto.getAddress() );
		newEmployee.setStatus( StatusEnum.CURRENT );

		return employeeRepository.save( newEmployee );
	}

	@Override
	public void deleteById( Integer id )
	{
		Optional < Employee > result = employeeRepository.findById( id );

		if ( result.isPresent() )
		{
			Employee employee = result.get();
			employee.setStatus( StatusEnum.DELETED );

			employeeRepository.save( employee );
			return;
		}

		throw new ResourceNotFoundException( NOT_FOUND_MESSAGE + id );
	}

	@Override
	public Employee update( UpdateEmployeeDto employeeDto )
	{
		int employeeId = employeeDto.getId();
		Optional < Employee > result = employeeRepository.findById( employeeId );

		if ( result.isPresent() )
		{
			Employee employee = result.get();

			employee.setFirstName( employeeDto.getFirstName() );
			employee.setLastName( employeeDto.getLastName() );
			employee.setNickName( employeeDto.getNickName() );
			employee.setAddress( employeeDto.getAddress() );

			return employeeRepository.save( employee );
		}

		throw new ResourceNotFoundException( NOT_FOUND_MESSAGE + employeeId );
	}

	@Override
	public Employee updateEmployeeSalary( int employeeId , Float percent )
	{
		if ( percent < 0 || percent > 100 )
		{
			throw new BadFormatException( "Percent should be between 0 and 100" );
		}

		Optional < Employee > result = employeeRepository.findById( employeeId );

		if ( result.isPresent() )
		{
			Employee employee = result.get();
			Float newSalary = calculateSalary( employee.getSalary() , percent );
			employee.setSalary( newSalary );

			return employeeRepository.save( employee );
		}

		throw new ResourceNotFoundException( NOT_FOUND_MESSAGE + employeeId );
	}

	@Override
	public Employee updateEmployeePosition( int employeeId , UpdateEmployeeDto employeeDto )
	{
		Optional < Employee > result = employeeRepository.findById( employeeId );

		if ( !result.isPresent() )
		{
			throw new ResourceNotFoundException( NOT_FOUND_MESSAGE + employeeId );
		}

		Employee employee = result.get();
		String position = employee.getPosition();
		String currentPos = employeeDto.getCurrentPos();
		String newPos = employeeDto.getNewPos();

		if ( !position.equals( currentPos ) )
		{
			throw new BadFormatException( "Current position is incorrect" );
		}

		employee.setPosition( newPos );

		return employeeRepository.save( employee );
	}

	@Override
	public List < Employee > searchEmployeeByName( String name )
	{
		return employeeRepository.findByFirstNameContaining( name );
	}

	@Override
	public List < Integer > deleteByIds( List < Integer > ids )
	{
		Set < Integer > setIds = new HashSet <>( ids );
		List < Employee > employeeList = employeeRepository.findAllById( ids );
		List < Integer > notFoundIds = new ArrayList <>();

		for ( Employee employee : employeeList )
		{
			employee.setStatus( StatusEnum.DELETED );
			setIds.remove( employee.getId() );
		}

		return new ArrayList <>( setIds );
	}

	private Float calculateSalary( Float salary , Float percent )
	{
		return ( float ) ( salary + salary * ( percent / 100.0 ) );
	}
}
