package fa.training.dao;

public interface EmployeeDao<T> {
	public boolean save(T job);
}
