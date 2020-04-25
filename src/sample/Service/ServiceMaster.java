package sample.Service;

import sample.Entities.Comanda;
import sample.Entities.Produs;
import sample.observer.Observable;

import java.io.IOException;
import java.util.List;

public class ServiceMaster extends Observable {
    private ServiceProdus serviceProdus;
    private ServiceComanda serviceComanda;

    public ServiceMaster(ServiceProdus serviceProdus, ServiceComanda serviceComanda) {
        this.serviceProdus = serviceProdus;
        this.serviceComanda = serviceComanda;
        loadData();
    }

    public void saveData() {
        try {
            serviceProdus.writeToFile("C:\\Users\\Polizei\\IdeaProjects\\RoomService\\src\\sample\\files\\produse.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void saveDataComanda() {
        try {
            serviceComanda.writeToFile("C:\\Users\\Polizei\\IdeaProjects\\RoomService\\src\\sample\\files\\comenzi.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void loadData() {
        try {
            serviceProdus.readFromFile("C:\\Users\\Polizei\\IdeaProjects\\RoomService\\src\\sample\\files\\produse.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Produs> findProduse(){ return serviceProdus.findAll();}

    public List<Comanda> findComenzi(){
        return serviceComanda.findAll();
    }

    public Produs addProdus(Produs c){
        Produs res=serviceProdus.addProdus(c);
        notifyObserver();
        saveData();
        return res;
    }

    public Comanda addComanda(Comanda c){
        Comanda res=serviceComanda.addComanda(c);
        notifyObserver();
        saveDataComanda();
        return res;
    }

    public Comanda removeComanda(Comanda c){
        Comanda res=serviceComanda.removeComanda(c);
        try {
            serviceComanda.writeToFileRez("C:\\Users\\Polizei\\IdeaProjects\\RoomService\\src\\sample\\files\\rezolvate.txt", c);
        }catch (IOException e) {
            e.printStackTrace();
        }
        notifyObserver();
        saveDataComanda();
        return res;
    }

}
