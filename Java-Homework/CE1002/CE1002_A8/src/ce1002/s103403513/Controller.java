package ce1002.s103403513;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

public class Controller {
    @FXML
    private ImageView buttonImage;
    @FXML
    private Label label;
    
    private AnimationTimer rectangleAnimation;
    private MediaPlayer mediaPlayer;
    private double rectangleSpeedX = 0 ; // pixels per second
    private double rectangleSpeedY = 0 ;
    private long lastUpdateTime = 0;
    private boolean play = false;
    private boolean speak = false;
    double textsize = 30;
    
    
    @FXML
    private void initialize() {
    	mediaPlayer = new MediaPlayer( new Media (new File("src/sound/sound.mp3").toURI().toString()));
    	//mediaPlayer = new MediaPlayer(new Media("file:///C:/Users/user/Coding/CollegeHomeworkCollection/Java-Homework/CE1002/CE1002_A8_new/src/sound/sound.mp3"));
        buttonImage.setImage ( new Image ("image/player.png") );
        label.setLayoutX(label.getLayoutX()+buttonImage.getBoundsInParent().getWidth()+10);
        label.setLayoutY(label.getLayoutY()+buttonImage.getBoundsInParent().getHeight()/2-textsize);//置中
        label.setFont(new Font(textsize));
        rectangleAnimation = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if (lastUpdateTime > 0) {
                    final double elapsedSeconds = (timestamp - lastUpdateTime) / 1_000_000_000.0 ;
                    final double deltaX = elapsedSeconds * rectangleSpeedX;
                    final double deltaY = elapsedSeconds * rectangleSpeedY;
                    final double oldX = buttonImage.getTranslateX();
                    final double oldY = buttonImage.getTranslateY();
                    final double newX = oldX + deltaX;
                    final double newY = oldY + deltaY;
                    buttonImage.setTranslateX(newX);
                    buttonImage.setTranslateY(newY);
                    label.setTranslateX(newX);
                    label.setTranslateY(newY);
                }
                lastUpdateTime = timestamp;
            }
        };
        
        rectangleAnimation.start ();
        
        buttonImage.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent event) {
				speak = !speak;
				if(speak){
					label.setText("再來啊！");
				}
				else label.setText("");
			}
        	
        });
        
    }
    public void setScene(Scene scene){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode()==KeyCode.RIGHT) {
                    rectangleSpeedX = 500;
                }
                if (event.getCode()==KeyCode.LEFT) {
                    rectangleSpeedX = -500;
                }
                if (event.getCode()==KeyCode.UP) {
                    rectangleSpeedY = -500;
                }
                if (event.getCode()==KeyCode.DOWN) {
                    rectangleSpeedY = +500;
                }
                if (event.getCode() == KeyCode.X ){
                	//System.out.println(mediaPlayer.getStatus () + " play: "+ play );
                	if(mediaPlayer.getStatus () == MediaPlayer.Status.PLAYING){
                		mediaPlayer.stop();
                		play = true;
                	}
                	else play = !play;
            
                }
                
            }
            
        });
        
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT ){
                    rectangleSpeedX = 0;
                }
                if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN ){
                    rectangleSpeedY = 0;
                }
                if (event.getCode() == KeyCode.X ){
                	if(play) mediaPlayer.play();//播放音效
                }
            }
        });
    }
}
