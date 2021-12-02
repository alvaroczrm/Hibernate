package es.studium.hibernate.dao;

import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T> implements Dao<T> {
	@Override
	public Optional<T> get(long id) {
// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T t) {
// TODO Auto-generated method stub
	}

	@Override
	public void update(T t) {
// TODO Auto-generated method stub
	}

	@Override
	public void delete(T t) {
// TODO Auto-generated method stub
	}
}
