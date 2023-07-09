package tech.kbtg.exams_solution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.kbtg.exams_solution.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository < Employee, Integer >
{
	List < Employee > findByFirstNameContaining( String firstName );
}
