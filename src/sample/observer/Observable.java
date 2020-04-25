package sample.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> list;

    public Observable() {
        list=new ArrayList<>();
    }

    public void addObserver(Observer o){
        list.add(o);
    }

    public void removeObserver(Observer o){
        list.remove(o);
    }

    public void notifyObserver(){
        for (Observer o:list){
            o.update();
        }
    }
}
