package fa.training.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Jobs")
public class Job {
	@Id
	@Column(name = "job_id", length = 10)
	private String jobId;

	@Column(name = "job_title", length = 255, nullable = false, unique = true)
	private String jobTitle;

	@Column(name = "min_salary", precision = 11, scale = 2)
	private double minSalary;

	@Column(name = "max_salary", precision = 11, scale = 2)
	private double maxSalary;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "job")
	private JobDetail jobDetail;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
	private Set<Employee> employees = new HashSet<Employee>();

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(String jobId, String jobTitle, double minSalary, double maxSalary) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public JobDetail getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}

}
