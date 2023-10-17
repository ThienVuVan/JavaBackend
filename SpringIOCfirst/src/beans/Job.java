package beans;

public class Job {
	private int jobId;
	private String jobName;
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Job(int jobId, String jobName) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
}
