package fa.training.dao;

import fa.training.entities.Job;

public interface JobDao {
	public boolean save(Job job);
	public boolean find();
	public boolean saveorupdate(Job job);
	public Job getById(String id);
}
