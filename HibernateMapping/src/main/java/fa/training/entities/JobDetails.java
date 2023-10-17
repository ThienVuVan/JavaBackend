package fa.training.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "JobDetails", schema = "dbo")
public class JobDetails {
	@Id
	@GeneratedValue
	@Column(name = "job_detail_id")
	private int jobDetailId;
	
	@Column(name = "job_description", length = 255)
	private String jobDescription;
	
	@Column(name = "active_date")
	private LocalDate activeDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "job_id", referencedColumnName = "job_id")
	private Jobs job;
	
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "jobDetail")
//	private Jobs job;

	public JobDetails() {
	
	}

	public JobDetails(String jobDescription, LocalDate activeDate) {
		this.jobDescription = jobDescription;
		this.activeDate = activeDate;
	}

	public int getJobDetailId() {
		return jobDetailId;
	}

	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public LocalDate getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(LocalDate activeDate) {
		this.activeDate = activeDate;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}
	
	
}
