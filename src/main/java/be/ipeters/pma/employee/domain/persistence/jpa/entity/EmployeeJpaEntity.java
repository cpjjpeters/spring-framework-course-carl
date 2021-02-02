package be.ipeters.pma.employee.domain.persistence.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import be.ipeters.pma.entities.ProjectJpaEntity;

@Entity
@Table(name="EMPLOYEE")
public class EmployeeJpaEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long employeeId;
	private String firstName;
	private String lastName; 
	private String email;
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectJpaEntity theProject;
	
	public ProjectJpaEntity getTheProject() {
		return theProject;
	}
	public void setTheProject(ProjectJpaEntity theProject) {
		this.theProject = theProject;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeJpaEntity() {
	}
	public EmployeeJpaEntity(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
}
