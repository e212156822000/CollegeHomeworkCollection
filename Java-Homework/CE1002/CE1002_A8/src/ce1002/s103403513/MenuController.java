package ce1002.s103403513;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
public class MenuController{
	@FXML
    private Pane Pane;
    @FXML
    private Button start_game;
    @FXML
    private Button exit_game;
    @FXML
    private void initialize(){
    	
    }
    public Button getPlayButton(){
		return start_game;
    }
    public void setScene(Scene scene){
    	/*
    	Stage stage = new Stage();
    	start_game.setOnAction ( new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gameview.fxml"));
				Controller controller = new Controller();
		        fxmlLoader.setController(controller);
		        Parent root = null;
				try { 
					root = fxmlLoader.load();
					System.out.println("loaded.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Scene scene = new Scene(root,1200,800);
				scene.setRoot(root);
				controller.setScene(scene);
				stage.setScene(scene);
				stage.show();
				//Pane.getChildren().setAll(root);
			}
    		
    	});
    	*/
   	}
}