package com.bookstore.dao;

public interface Dao<T> {
	public boolean save(T t);
	public boolean update(T t);
	public boolean saveorupdate(T t);
	public T getById(Object t);
	public boolean merge(T t);
}
