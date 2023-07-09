package tech.kbtg.exams_solution.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tech.kbtg.exams_solution.dto.CreateEmployeeDto;
import tech.kbtg.exams_solution.dto.NotFoundEmployeeDto;
import tech.kbtg.exams_solution.dto.UpdateEmployeeDto;
import tech.kbtg.exams_solution.entity.Employee;
import tech.kbtg.exams_solution.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping ( "/employees" )
public class EmployeeController
{
	private EmployeeService employeeService;

	public EmployeeController( EmployeeService employeeService )
	{
		this.employeeService = employeeService;
	}

	@GetMapping ( "/" )
	public ResponseEntity < List < Employee > > getAllEmployees()
	{
		return ResponseEntity.ok( employeeService.getAllEmployees() );
	}

	@GetMapping ( "/{id}" )
	public ResponseEntity < Employee > getEmployeeById( @PathVariable ( name = "id" ) int employeeId )
	{
		return ResponseEntity.ok( employeeService.getEmployeeById( employeeId ) );
	}

	@PostMapping ( "/" )
	public ResponseEntity < Employee > createEmployee( @RequestBody CreateEmployeeDto employeeDto )
	{
		return ResponseEntity.ok( employeeService.createEmployee( employeeDto ) );
	}

	@DeleteMapping ( "/{id}" )
	public ResponseEntity < ? > deleteEmployeeId( @PathVariable ( name = "id" ) int employeeId )
	{
		employeeService.deleteById( employeeId );
		return ResponseEntity.noContent().build();
	}

	@PutMapping ( "/" )
	public ResponseEntity < Employee > updateEmployee( @RequestBody UpdateEmployeeDto employeeDto )
	{
		return ResponseEntity.ok( employeeService.update( employeeDto ) );
	}

	@PutMapping ( "/salary/{id}" )
	public ResponseEntity < Employee > updateEmployeeSalary( @RequestBody UpdateEmployeeDto employeeDto , @PathVariable ( name = "id" ) int employeeId )
	{
		return ResponseEntity.ok( employeeService.updateEmployeeSalary( employeeId , employeeDto.getPercent() ) );
	}

	@PutMapping ( "/position/{id}" )
	public ResponseEntity < Employee > updateEmployeePosition( @RequestBody UpdateEmployeeDto employeeDto , @PathVariable ( name = "id" ) int employeeId )
	{
		return ResponseEntity.ok( employeeService.updateEmployeePosition( employeeId , employeeDto ) );
	}

	@GetMapping ( "/name" )
	public ResponseEntity < List < Employee > > searchEmployeeByName( @RequestParam ( name = "q" ) String name )
	{
		return ResponseEntity.ok( employeeService.searchEmployeeByName( name ) );
	}

	@DeleteMapping ( "/" )
	public ResponseEntity < ? > deleteEmployByIdList( @RequestParam List < Integer > ids )
	{
		List < Integer > notFoundIds = employeeService.deleteByIds( ids );

		if ( notFoundIds.size() > 0 )
		{
			NotFoundEmployeeDto notFoundEmployeeDto = new NotFoundEmployeeDto( notFoundIds );
			return ResponseEntity.status( HttpStatus.MULTI_STATUS ).body( notFoundEmployeeDto );
		}

		return ResponseEntity.noContent().build();
	}
}
