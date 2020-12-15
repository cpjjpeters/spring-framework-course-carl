package be.ipeters.pma.api.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.ipeters.pma.employee.domain.EmployeeRepository;
import be.ipeters.pma.employee.domain.persistence.jpa.entity.EmployeeJpaEntity;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public Iterable<EmployeeJpaEntity> getEmployees(){
		return empRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public EmployeeJpaEntity getEmployeeById(@PathVariable("id") Long id) {
		return empRepo.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeJpaEntity create(@RequestBody  EmployeeJpaEntity employee) {//import javax.validation.Valid;
		return empRepo.save(employee);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeJpaEntity update(@RequestBody  EmployeeJpaEntity employee) { //@Valid
		return empRepo.save(employee);
	}
	
	@PatchMapping(path="/{id}", consumes= "application/json")
	public EmployeeJpaEntity partialUpdate(@PathVariable("id") long id, @RequestBody  EmployeeJpaEntity patchEmployee) {
		EmployeeJpaEntity emp = empRepo.findById(id).get();
		
		if(patchEmployee.getEmail() != null) {
			emp.setEmail(patchEmployee.getEmail());
		}
		if(patchEmployee.getFirstName() != null) {
			emp.setFirstName(patchEmployee.getFirstName());
		}
		if(patchEmployee.getLastName() != null) {
			emp.setLastName(patchEmployee.getLastName());
		}
		
		return empRepo.save(emp);
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		try {
		empRepo.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
	}
	
	@GetMapping(params= {"page", "size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<EmployeeJpaEntity> findPaginatedEmployees(@RequestParam("page") int page, 
											@RequestParam("size") int size){
		Pageable pageAndSize = PageRequest.of(page, size);
		
		return empRepo.findAll();  //return empRepo.findAll(pageAndSize);
	}
	
}
