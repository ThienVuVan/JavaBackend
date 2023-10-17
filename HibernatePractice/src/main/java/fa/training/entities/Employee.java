package fa.training.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "employees")
@NamedQueries(value = { @NamedQuery(name = "FindAllEmployee", query = "FROM Employee e") })
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@Length(min = 3, max = 20)
	@NotEmpty
	@Column(name = "first_name")
	private String firstName;
	
	@Size(min = 3, max = 20)
	@NotEmpty
	@Column(name = "last_name")
	private String lastName;
	
	//@Pattern(regexp = "\\d{10}")
	@Column(name = "phone")
	private String phone;
	
//	@Column(name = "age")
//	private int age;
//	
	@Email
	@Column(name = "email")
	private String email;

	@Range(min = 100, max = 100000)
	@Column(name = "salary", precision = 11, scale = 2)
	private Double salary;
	
//	@URL(protocol = "https")
//	@Column(name = "url")
//	private String url;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_id", referencedColumnName = "job_id")
	private Job job;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_project", joinColumns = {
			@JoinColumn(referencedColumnName = "employee_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "project_id") })
	private Set<Project> projects = new HashSet<Project>();

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String phone, Double salary, String url) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.salary = salary;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
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

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
