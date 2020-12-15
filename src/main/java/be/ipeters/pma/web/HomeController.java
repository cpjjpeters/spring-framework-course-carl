package be.ipeters.pma.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.ipeters.pma.dao.ProjectRepository;
import be.ipeters.pma.employee.domain.EmployeeService;
import be.ipeters.pma.employee.domain.persistence.jpa.entity.EmployeeJpaEntity;
import be.ipeters.pma.entities.ProjectJpaEntity;
import be.ipeters.pma.user.domain.User;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/home")
	public String displayHome(Model model) {
		
		List<ProjectJpaEntity> projects = proRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<EmployeeJpaEntity> employees = empService.findAll();
		model.addAttribute("employeesList", employees);
		
		return "main/home";
	}

	@GetMapping("/")  // this is from before the real pma
	public String home(Model model) {
		model.addAttribute("formData", new User());
		return "index";
	}
	@PostMapping("/create")
	public String processFormDate(User user, RedirectAttributes attr) {
//		 insert in DB
		
		attr.addFlashAttribute("user", user);
		return "redirect:/display";
	}
	@GetMapping("/display")
	public String displayFormData(User user) {

		return "result";
	}
}
