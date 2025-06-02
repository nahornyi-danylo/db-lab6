package db.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, K> {
  Optional<T> findById(K id) throws Exception;
  List<T>     findAll()    throws Exception;
  K           create(T entity) throws Exception;
  boolean     update(T entity) throws Exception;
  boolean     delete(K id) throws Exception;
}