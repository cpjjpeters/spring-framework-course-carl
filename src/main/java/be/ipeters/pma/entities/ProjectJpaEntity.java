package be.ipeters.pma.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import be.ipeters.pma.employee.domain.persistence.jpa.entity.EmployeeJpaEntity;
import lombok.Data;

@Data
@Entity
@Table(name="PROJECT")
public class ProjectJpaEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long projectId;
	private String name;
	private String stage; // NOT STARTED, complete, in progress
	private String description;
	@OneToMany(mappedBy="theProject")
	private List<EmployeeJpaEntity> employees;

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public List<EmployeeJpaEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeJpaEntity> employees) {
		this.employees = employees;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProjectJpaEntity(String name, String stage, String description) {
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public ProjectJpaEntity() {
	}
	
	
	

}
