package sample.Service;

import sample.Entities.Produs;
import sample.Repository.RepoProdus;

import java.io.IOException;
import java.util.List;

public class ServiceProdus {

    private RepoProdus repoProdus;

    public ServiceProdus(RepoProdus repoIntrebare) {
        this.repoProdus = repoIntrebare;
    }

    public Produs findOne(int id){
        return repoProdus.findOne(id);
    }

    public List<Produs> findAll(){
        return repoProdus.findAll();
    }


    public void writeToFile(String numeFisier) throws IOException {
        repoProdus.writeToFile(numeFisier);
    }

    public void readFromFile(String numeFisier) throws IOException {
        repoProdus.readFromFile(numeFisier);
    }

    public Produs addProdus(Produs c){
        return repoProdus.save(c);
    }


}
