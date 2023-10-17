package fa.training.dao;

public interface Dao<T> {
	public boolean save(T t);
	public boolean update(T t);
}
