package be.ipeters.pma.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import be.ipeters.pma.dao.ProjectRepository;
import be.ipeters.pma.entities.ProjectJpaEntity;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		ProjectJpaEntity aProject = new ProjectJpaEntity();
		model.addAttribute("project", aProject);
		return "projects/new-project";
	}

	@PostMapping("/save" )
	public String createProject(ProjectJpaEntity project, Model model) {
//		 this should save in db
		log.info("projects/save");
		proRepo.save(project);
		// use to prevent duplicate submissions
		return "redirect:/projects/new";
	}
	
	@GetMapping("/list")
	public String displayListProjects(Model model) {
		List<ProjectJpaEntity> lstProjects = proRepo.findAll();
		model.addAttribute("projects", lstProjects);
		return "projects/list-projects";
	}

}
