package sample.Validator;

import sample.Entities.Comanda;

public class ValidatorComanda implements Validation<Comanda> {

    @Override
    public void Validate(Comanda intrebare) throws ValidationException{
        String err="";
        if (intrebare.getId()<0)
            err+="Id invalid";
        if (intrebare.getNume()==null)
            err+="Nume invalid";
        if (intrebare.getPret()<0)
            err+="Pret invalid";
        if (!err.equals(""))
            throw new ValidationException(err);
    }
}

