package fa.training.dao;

public interface JobDao<T> {
	public boolean save(T job);
}
