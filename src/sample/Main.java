package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Controller.ProdusController;
import sample.Repository.RepoComanda;
import sample.Repository.RepoProdus;
import sample.Service.ServiceComanda;
import sample.Service.ServiceMaster;
import sample.Service.ServiceProdus;
import sample.Validator.ValidatorComanda;
import sample.Validator.ValidatorProdus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    private ServiceMaster master;

    @Override
    public void start(Stage primaryStage) throws Exception{
        init();
        List<Stage> stages = new LinkedList<>();
        List<String> a=new ArrayList<>();
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        a.add(s);
        s=in.nextLine();
        a.add(s);
        stages.add(createScene("Administrator"));
        for (String f:a){
            stages.add(createScene(f));
        }
        stages.forEach(x->x.show());

    }

    public void init(){
        ValidatorProdus validatorCheltuiala=new ValidatorProdus();
        RepoProdus repoCheltuiala=new RepoProdus(validatorCheltuiala);
        ServiceProdus serviceCheltuiala=new ServiceProdus(repoCheltuiala);

        ValidatorComanda validatorRaspuns=new ValidatorComanda();
        RepoComanda repoRezultat=new RepoComanda(validatorRaspuns);
        ServiceComanda serviceRaspuns=new ServiceComanda(repoRezultat);

        this.master=new ServiceMaster(serviceCheltuiala,serviceRaspuns);
    }

    public Stage createScene(String nrCamera) throws IOException
    {
        BorderPane root;
        FXMLLoader loaderAdulti = new FXMLLoader();
        loaderAdulti.setLocation(getClass().getResource("/sample/View/produsView.fxml"));
        root = loaderAdulti.load();

        ProdusController controller = loaderAdulti.getController();
        controller.init(master,nrCamera);

        Stage stage = new Stage();

        stage.setScene(new Scene(root,750,500));
        stage.setTitle("Camera: " + nrCamera);

        return stage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
