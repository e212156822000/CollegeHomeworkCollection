package ce1002.s103403513;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.util.Duration;

public class Controller {
    @FXML
    private ImageView buttonImage;
    private AnimationTimer rectangleAnimation;

    private double rectangleSpeedX = 0 ; // pixels per second
    private double rectangleSpeedY = 0 ;
    private long lastUpdateTime = 0;
    private double opacityStart = 1.0;
    private double opacityEnd = 0.5;
    @FXML
    private void initialize() {
        buttonImage.setImage ( new Image ("image/player.png") );

        rectangleAnimation = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if (lastUpdateTime > 0) {
                    final double elapsedSeconds = (timestamp - lastUpdateTime) / 1_000_000_000.0 ;
                    System.out.println(elapsedSeconds);
                    final double deltaX = elapsedSeconds * rectangleSpeedX;
                    final double deltaY = elapsedSeconds * rectangleSpeedY;
                    final double oldX = buttonImage.getTranslateX();
                    final double oldY = buttonImage.getTranslateY();
                    final double newX = oldX + deltaX;
                    final double newY = oldY + deltaY;
                    buttonImage.setTranslateX(newX);
                    buttonImage.setTranslateY(newY);
                }
                lastUpdateTime = timestamp;
            }
        };
        rectangleAnimation.start ();


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
                	if(opacityStart == 1.0){
                		opacityStart = 0.5;
                		opacityEnd = 1.0;
                	}else{
                		opacityStart = 1.0;
                		opacityEnd = 0.5;
                	}
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
                	FadeTransition ft = new FadeTransition(Duration.millis(500), buttonImage);
                	ft.setFromValue(opacityStart);
                	ft.setToValue(opacityEnd);
                	ft.play();
                }
            }
        });
    }
}
