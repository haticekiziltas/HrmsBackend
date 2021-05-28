package kodlamaio.hrmsdemo.adapters.abstracts;

public interface IdentityCheckService<T> {
    boolean validate(T data) throws Exception;
}
