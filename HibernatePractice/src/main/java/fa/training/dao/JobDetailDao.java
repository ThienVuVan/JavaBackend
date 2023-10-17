package fa.training.dao;

import fa.training.entities.JobDetail;

public interface JobDetailDao {
	public boolean save(JobDetail job);
	public boolean find();
	public boolean saveorupdate(JobDetail job);
	public JobDetail getById(int id);
}
