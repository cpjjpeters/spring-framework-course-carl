package be.ipeters.pma.employee.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import be.ipeters.pma.employee.domain.model.Employee;
import be.ipeters.pma.employee.domain.persistence.jpa.entity.EmployeeJpaEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {
	
	private final EmployeeRepository empRepo;

	public EmployeeService(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	public void save(EmployeeJpaEntity employee) {
		empRepo.save(employee);
		
	}

	public List<EmployeeJpaEntity> findAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	public void delete(EmployeeJpaEntity theEmp) {
		empRepo.delete(theEmp);
		
	}


}
