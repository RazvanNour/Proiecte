package sample.Repository;

import sample.Entities.Entity;
import sample.Validator.Validation;
import sample.Validator.ValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class RepoAbstract<ID, E extends Entity> implements IRepo<ID, E> {

    private List<E> list;
    private Validation val;

    public RepoAbstract(Validation val) {
        this.list=new ArrayList<>();
        this.val = val;
    }

    @Override
    public E save(E e) throws ValidationException {
        val.Validate(e);
        if (list.contains(e))
            return e;
        list.add(e);
        return null;
    }

    @Override
    public E remove(E e) {
        if (list.contains(e)){
            list.remove(e);
            return e;}
        return null;
    }

    @Override
    public E update(E e) throws ValidationException {
        val.Validate(e);
        if (!list.contains(e))
            return e;
        for (E temp:list)
            if (e.equals(temp))
                temp=e;
        return null;
    }

    @Override
    public E findOne(ID id) {
        for (E e:list){
            if (e.getId().equals(id))
                return e;
        }
        return null;
    }

    @Override
    public List<E> findAll() {
        return list;
    }

    public abstract E convertFromString(String s);

    public void readFromFile(String s) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(s));
        String line="";
        while ((line=bufferedReader.readLine()) !=null){
            E e=convertFromString(line);
            if (e!=null)
                save(e);
        }
        bufferedReader.close();
    }



    public void writeToFile(String s) throws IOException {
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(s));
        String data="";
        for (E e:list){
            data+=e.toString()+"\n";
        }
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public void writeToFileRez(String s, E el) throws IOException{
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(s));
        String data="";
        data+=el.toString()+"\n";
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

}
