package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<K extends Serializable, T> {
	public T getById(K id);

	public List<T> getAll();

	public K create(T value);

	public void update(T value);

	public void delete(T value);
}
