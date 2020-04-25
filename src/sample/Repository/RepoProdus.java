package sample.Repository;

import sample.Entities.Produs;
import sample.Validator.Validation;

import java.util.ArrayList;
import java.util.List;

public class RepoProdus extends RepoAbstract<Integer, Produs> {
    public RepoProdus(Validation val){
        super(val);
    }

    @Override
    public Produs convertFromString(String s) {
        String []arr=s.split(" ");
        if (arr.length!=3)
            return null;
        int id=Integer.parseInt(arr[0]);
        String nume=arr[1];
        int pret=Integer.parseInt(arr[2]);
        Produs c=new Produs(id,nume,pret);
        return c;

    }
}
