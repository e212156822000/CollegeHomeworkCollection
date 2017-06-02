package edu.american;
import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Controller {
	@FXML
    private Button PlayButton;
    @FXML
    private Button RetryButton;
    @FXML
    private Pane pane;
    private int Music_Scale = 3;
    private int Num_Keys = 7;
    private String[] keys = {"c","d","e","F","G","A","B"};
    
    @FXML
    private void initialize() {
    	PlayButton.setText("開始彈奏");
    	RetryButton.setText("重新播放");
    	Stage stage  = new Stage();
    	int x = 55;
    	int y = 20;
    	Group root = new Group();
    	Scene scene = new Scene(root);
        HBox box = new HBox();
    	for(int i = 0;i < Music_Scale ; i++){
    		for(int j = 0;j< Num_Keys ;j++){
    			ImageView imageView = new ImageView(new Image("images/"+keys[j]+".png"));
    			imageView.relocate(x, y);
    			box.getChildren().add(imageView);
    		}
    	}
    	scene.setFill(Color.BLACK);
    	root.getChildren().add(box);
    	
        
    }
    public void setScene(Scene scene){
    	
        /*
    	stage.setTitle("ImageView");
        stage.setScene(scene); 
        stage.sizeToScene(); 
        stage.show(); 
        */
    	/*
        scene.setOnKeyPressed ( new EventHandler<KeyEvent> () {
            @Override
            public void handle ( KeyEvent event ) {
                if(event.getCode() == KeyCode.UP) {
                    WhiteKey.setTranslateY ( WhiteKey.getTranslateY () - 10 );
                }
                if(event.getCode() == KeyCode.DOWN) {
                    WhiteKey.setTranslateY ( WhiteKey.getTranslateY () + 10 );
                }
                if(event.getCode() == KeyCode.LEFT) {
                    WhiteKey.setTranslateX ( WhiteKey.getTranslateX () - 10 );
                }
                if(event.getCode() == KeyCode.RIGHT) {
                    WhiteKey.setTranslateX ( WhiteKey.getTranslateX () + 10 );
                }
                if(event.getCode() == KeyCode.X) {
                    WhiteKey.setRotate ( WhiteKey.getRotate () + 10*i );
                }
            }
        } );
        */
    }
}
