package ce1002.s103403513;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Controller controller = new Controller ();
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Wo Shi Ton Hei");
        Scene scene = new Scene ( root, 600, 400 );
        controller.setScene ( scene );
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
