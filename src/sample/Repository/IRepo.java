package sample.Repository;

import sample.Entities.Entity;
import sample.Validator.ValidationException;

import java.util.List;

public interface IRepo <ID, E extends Entity>{
    public E save (E e) throws ValidationException;
    public E remove (E e);
    public E update (E e) throws ValidationException;
    public E findOne (ID id);
    public List<E> findAll ();
}
