package be.ipeters.pma.employee.domain.web.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import be.ipeters.pma.employee.domain.EmployeeService;
import be.ipeters.pma.employee.domain.persistence.jpa.entity.EmployeeJpaEntity;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		EmployeeJpaEntity aEmployee = new EmployeeJpaEntity();
		model.addAttribute("employee", aEmployee);
		return "employees/new-employee";
	}

	@PostMapping("/save" )
	public String createEmployee(EmployeeJpaEntity employee, Model model) {
//		 this should save in db
		log.info("employees/save");
		empService.save(employee);
		// use to prevent duplicate submissions
		return "redirect:/employees/new";  // url redirect
	}
	
	@GetMapping("/list")
	public String displayListEmployees(Model model) {
		List<EmployeeJpaEntity> lstEmployees = empService.findAll();
		model.addAttribute("employees", lstEmployees);
		return "employees/list-employees";
	}

}
