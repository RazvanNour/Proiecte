package sample.Validator;

import sample.Entities.Entity;

public interface Validation <E extends Entity>{

    public void Validate(E e) throws ValidationException;
}
