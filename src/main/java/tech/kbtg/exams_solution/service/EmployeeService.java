package tech.kbtg.exams_solution.service;

import tech.kbtg.exams_solution.dto.CreateEmployeeDto;
import tech.kbtg.exams_solution.dto.UpdateEmployeeDto;
import tech.kbtg.exams_solution.entity.Employee;

import java.util.List;

public interface EmployeeService
{
	List < Employee > getAllEmployees();

	Employee getEmployeeById( Integer id );

	Employee createEmployee( CreateEmployeeDto employeeDto );

	void deleteById( Integer id );

	Employee update( UpdateEmployeeDto employeeDto );

	Employee updateEmployeeSalary( int employeeId , Float percent );

	Employee updateEmployeePosition( int employeeId , UpdateEmployeeDto employeeDto );

	List < Employee > searchEmployeeByName( String name );

	List < Integer > deleteByIds( List < Integer > ids );
}
