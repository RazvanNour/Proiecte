package sample.Entities;

import java.time.LocalDate;
import java.util.Objects;


public class Comanda extends Entity<Integer>{
        private String nrCamera;
        private String nume;
        private int pret;
        private LocalDate timp;


        public Comanda(int id,String nrCamera, String nume, int pret, LocalDate timp) {
            setId(id);
            this.nrCamera=nrCamera;
            this.nume = nume;
            this.pret = pret;
            this.timp=timp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Comanda produs = (Comanda) o;
            return getId().equals(produs.getId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(pret);
        }

        @Override
        public String toString() {
            return getId()+" "+nrCamera+" "+nume+" "+pret+LocalDate.now();
        }

    public String getNrCamera() {
        return nrCamera;
    }

    public void setNrCamera(String nrCamera) {
        this.nrCamera = nrCamera;
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

    public LocalDate getTimp() {
        return timp;
    }

    public void setTimp(LocalDate timp) {
        this.timp = timp;
    }
}
