package edu.american;
import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
public class Controller {
    @FXML
    private ImageView WhiteKey;
    @FXML
    private ImageView BlackKey;
    @FXML
    private Button PlayButton;
    @FXML
    private Button RetryButton;
    private int i = 1;
    @FXML
    private void initialize() {
    	PlayButton.setText("開始彈奏");
    	RetryButton.setText("重新播放");
    	File file = new File("src/images/a.png");
        Image image = new Image(file.toURI().toString());
        WhiteKey.setImage(image);
        
        file = new File("src/images/blackKey.png");
        image = new Image(file.toURI().toString());
        
        BlackKey.setImage( image );
        PlayButton.setOnAction( new EventHandler<ActionEvent> () {
            @Override
            public void handle ( ActionEvent event ) {
            	i = -i;
            }
        } );
        
    }
    public void setScene(Scene scene){
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
    }
}
