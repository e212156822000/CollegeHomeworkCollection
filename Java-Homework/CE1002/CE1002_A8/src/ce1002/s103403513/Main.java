package ce1002.s103403513;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
	Scene menu,gameview;
	Stage thisStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	thisStage = primaryStage;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gameview.fxml"));
        Controller controller = new Controller();
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        gameview = new Scene ( root, 1200, 700 );
        gameview.getStylesheets().add("gameview.css");
        controller.setScene(gameview);
       
    	fxmlLoader = new FXMLLoader(getClass().getResource("/menu.fxml"));
        MenuController Menucontroller = new MenuController();
        fxmlLoader.setController(Menucontroller);
        root = fxmlLoader.load();
        menu = new Scene ( root, 1200, 700 );
        menu.getStylesheets().add("gameview.css");
        
        Menucontroller.getPlayButton().setOnAction(e-> ButtonClicked(e));
        
        primaryStage.setTitle("Game");
        Menucontroller.setScene (menu);
        primaryStage.setScene(menu);
        primaryStage.show();
  
    }


	private void ButtonClicked(ActionEvent e) {
		// TODO Auto-generated method stub
		thisStage.setScene(gameview);
	}


	public static void main(String[] args) {
        launch(args);
    }
}
