package be.ipeters.pma.employee.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import be.ipeters.pma.employee.domain.persistence.jpa.entity.EmployeeJpaEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeJpaEntity, Long> {
	
	@Override
	public List<EmployeeJpaEntity> findAll();

	public EmployeeJpaEntity findByEmployeeId(long id);

}
