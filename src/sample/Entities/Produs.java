package sample.Entities;

import java.util.Objects;

public class Produs extends Entity<Integer>{
    private String nume;
    private int pret;


    public Produs(int id,String nume, int pret) {
        setId(id);
        this.nume = nume;
        this.pret = pret;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return getId().equals(produs.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(pret);
    }

    @Override
    public String toString() {
        return getId()+" "+nume+" "+pret;
    }
}
