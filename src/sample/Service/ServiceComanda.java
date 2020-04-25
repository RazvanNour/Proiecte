package sample.Service;

import sample.Entities.Comanda;
import sample.Repository.RepoComanda;

import java.io.IOException;
import java.util.List;

public class ServiceComanda {
    private RepoComanda repoComanda;

    public ServiceComanda(RepoComanda repoIntrebare) {
        this.repoComanda = repoIntrebare;
    }

    public Comanda findOne(int id){
        return repoComanda.findOne(id);
    }

    public List<Comanda> findAll(){
        return repoComanda.findAll();
    }


    public void writeToFile(String numeFisier) throws IOException {
        repoComanda.writeToFile(numeFisier);
    }
    public void writeToFileRez(String numeFisier,Comanda c) throws IOException {
        repoComanda.writeToFileRez(numeFisier,c);}

    public Comanda addComanda(Comanda c){
        return repoComanda.save(c);
    }

    public Comanda removeComanda(Comanda c){
        return repoComanda.remove(c);
    }

}
