package tech.kbtg.exams_solution;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.kbtg.exams_solution.dto.CreateEmployeeDto;
import tech.kbtg.exams_solution.service.EmployeeService;

@SpringBootApplication
public class ExamsSolutionApplication
{

	public static void main( String[] args )
	{
		SpringApplication.run( ExamsSolutionApplication.class , args );
	}

	@Bean
	public CommandLineRunner initData( EmployeeService employeeService )
	{
		return runner -> {
			CreateEmployeeDto employeeDto1 = new CreateEmployeeDto();
			employeeDto1.setFirstName( "Somchai" );
			employeeDto1.setLastName( "Rukdee" );
			employeeDto1.setNickName( "Thep" );
			employeeDto1.setAddress( "578 Address" );
			employeeDto1.setSalary( 30000.0f );
			employeeDto1.setPosition( "Software Engineer" );

			CreateEmployeeDto employeeDto2 = new CreateEmployeeDto();
			employeeDto2.setFirstName( "Saiparn" );
			employeeDto2.setLastName( "Jitdee" );
			employeeDto2.setNickName( "Nam" );
			employeeDto2.setAddress( "852 Address" );
			employeeDto2.setSalary( 60000.0f );
			employeeDto2.setPosition( "Sale Engineer" );

			CreateEmployeeDto employeeDto3 = new CreateEmployeeDto();
			employeeDto3.setFirstName( "Paiboon" );
			employeeDto3.setLastName( "Thaicho" );
			employeeDto3.setNickName( "Joe" );
			employeeDto3.setAddress( "241 Address" );
			employeeDto3.setSalary( 45000.0f );
			employeeDto3.setPosition( "Director Engineer" );

			employeeService.createEmployee( employeeDto1 );
			employeeService.createEmployee( employeeDto2 );
			employeeService.createEmployee( employeeDto3 );
		};
	}

}
