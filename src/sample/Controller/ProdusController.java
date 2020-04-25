package sample.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Entities.Comanda;
import sample.Entities.Produs;
import sample.Service.ServiceMaster;
import sample.Service.ServiceProdus;
import sample.observer.Observer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class ProdusController implements Observer {
    private ServiceMaster serviceMaster;
    private String nrCamera;


    @FXML
    private Label camera;

    @FXML
    private TableView<Produs> tabelProduse;

    @FXML
    private TableView<Comanda> tabelComenzi;

    @FXML
    private Label suma;

    public ProdusController(){}

    public void init(ServiceMaster serviceMaster, String nrCamera) {
        this.serviceMaster = serviceMaster;
        this.nrCamera = nrCamera;
        tabelProduse.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        updateTable(serviceMaster.findProduse());
        if (nrCamera=="Administrator")
            updateTableAdmin(serviceMaster.findComenzi());
        else
            updateTableClient(serviceMaster.findComenzi());
        camera.setText("Numarul camerei: "+nrCamera);
        suma.setText(updateSuma(serviceMaster.findComenzi()));
        serviceMaster.addObserver(this);

    }

    @Override
    public void update() {
        updateTable(serviceMaster.findProduse());
        if (nrCamera=="Administrator")
            updateTableAdmin(serviceMaster.findComenzi());
        else
            updateTableClient(serviceMaster.findComenzi());
        suma.setText(updateSuma(serviceMaster.findComenzi()));
        }

        public String updateSuma(List<Comanda>l){
            int s=0;
            for (Comanda el:l){
                if (el.getNrCamera()==nrCamera)
                    s+=el.getPret();
            }
            return Integer.toString(s);
        }

        public void updateTable(List<Produs> l){
        tabelProduse.getItems().clear();
        for (Produs el:l)
            tabelProduse.getItems().add(el);

        }

    public Stage createScene() throws IOException
    {
        BorderPane root;
        FXMLLoader loaderJ = new FXMLLoader();
        loaderJ.setLocation(getClass().getResource("/sample/View/adaugaView.fxml"));
        root = loaderJ.load();

        AdaugaController controller = loaderJ.getController();


        Stage stage = new Stage();
        controller.init(serviceMaster,stage);
        stage.setScene(new Scene(root,750,500));


        return stage;
    }

    public void AdaugaProdus() throws IOException {
        if (nrCamera=="Administrator")
             createScene().show();
    }

        public void updateTableAdmin(List<Comanda>l){
        tabelComenzi.getItems().clear();
        for (Comanda el:l){
            tabelComenzi.getItems().add(el);
        }
        }

        public void updateTableClient(List<Comanda> l){
        tabelComenzi.getItems().clear();
        for (Comanda el:l){
            if (el.getNrCamera()==nrCamera)
                tabelComenzi.getItems().add(el);
        }
        }

        public void comanda(){
        if (nrCamera!="Administrator") {
            Produs c = tabelProduse.getSelectionModel().getSelectedItem();
            if (c==null)
                return;
            Comanda x = new Comanda((int) (Math.random() * ((10000 - 1) + 1)), nrCamera, c.getNume(), c.getPret(), LocalDate.now());
            Comanda y = serviceMaster.addComanda(x);
        }
        }

        public void rezolva(){
        if (nrCamera=="Administrator") {
            Comanda c = tabelComenzi.getSelectionModel().getSelectedItem();
            if (c == null)
                return;
            Comanda y = serviceMaster.removeComanda(c);
        }
        }

}
