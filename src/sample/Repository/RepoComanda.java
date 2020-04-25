package sample.Repository;

import sample.Entities.Comanda;
import sample.Validator.Validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepoComanda extends RepoAbstract<Integer, Comanda> {
    public RepoComanda(Validation val){
        super(val);
    }

    @Override
    public Comanda convertFromString(String s) {
        String []arr=s.split(" ");
        if (arr.length!=7)
            return null;
        int id=Integer.parseInt(arr[0]);
        String descriere=arr[1];
        List<String> var=new ArrayList<>();
        var.add(arr[2]);
        var.add(arr[3]);
        var.add(arr[4]);
        int rasp=Integer.parseInt(arr[5]);
        int pct=Integer.parseInt(arr[6]);
        Comanda c=new Comanda(id,descriere,descriere,pct, LocalDate.now());
        return c;

    }


}
