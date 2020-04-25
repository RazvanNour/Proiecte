package sample.Controller;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ErrorMessageAlert {
    public static void showErrMessage(Stage s, String header, String err){
        Alert message=new Alert(Alert.AlertType.ERROR);
        message.setTitle(header);
        message.setContentText(err);
        message.initOwner(s);

        message.showAndWait();
    }
}
