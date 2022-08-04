package shared;

public interface FakeRepositoryAdapter<T> {

    T save(T entity);
}
