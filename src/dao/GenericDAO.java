package dao;
import java.util.List;

public interface GenericDAO<T> {
	public T find(Long id);
	public List<T> findAll();
	public void add(T object);
	public void update(T object);
	public void delete(Long id);
}

