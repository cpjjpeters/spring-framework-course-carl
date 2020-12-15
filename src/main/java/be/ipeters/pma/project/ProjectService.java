package be.ipeters.pma.project;

import java.util.List;

import org.springframework.stereotype.Service;

import be.ipeters.pma.dao.ProjectRepository;
import be.ipeters.pma.dto.ChartData;
import be.ipeters.pma.dto.TimeChartData;
import be.ipeters.pma.entities.ProjectJpaEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProjectService {
	
	private final ProjectRepository proRepo;

	public ProjectService(ProjectRepository proRepo) {
		super();
		this.proRepo = proRepo;
	}
	
	public ProjectJpaEntity save(ProjectJpaEntity project) {
		return proRepo.save(project);
	}
	
	public List<ProjectJpaEntity> getAll(){
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}
	
	
	public List<TimeChartData> getTimeData(){
		return proRepo.getTimeData();
	}

}
