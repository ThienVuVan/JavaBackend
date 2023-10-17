package fa.training.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "project_id")
	@GeneratedValue
	private int projectId;

	@Column(name = "title")
	private String title;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "Complete_date")
	private LocalDate completeDate;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "projects")
	private Set<Employee> employees = new HashSet<Employee>();

	public Project() {
		super();
	}

	public Project(String title, LocalDate startDate, LocalDate completeDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.completeDate = completeDate;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return projectId + " - " + title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(LocalDate completeDate) {
		this.completeDate = completeDate;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
