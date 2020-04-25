package sample.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Entities.Produs;
import sample.Service.ServiceMaster;
import sample.observer.Observer;

public class AdaugaController implements Observer {
    private ServiceMaster serviceMaster;
    private Stage stage;


    @Override
    public void update() {

    }

    public AdaugaController() {
    }

    public void setClear() {

    }

    @FXML
    private Label label;

    @FXML
    private TextField textId;

    @FXML
    private TextField textNume;

    @FXML
    private TextField textPret;


    public void init(ServiceMaster serviceMaster, Stage stage) {
        this.serviceMaster = serviceMaster;
        this.stage=stage;
        setClear();
    }


    public void adaugaP() {
        try{
            int id = Integer.parseInt(textId.getText());
            String nume = textNume.getText();
            int pret=Integer.parseInt(textPret.getText());
            Produs p=new Produs(id,nume,pret);
            serviceMaster.addProdus(p);}
        catch(Exception e){
            ErrorMessageAlert.showErrMessage(null,"Error","Produs rau");
        }
        stage.close();
    }

}