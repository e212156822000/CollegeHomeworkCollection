package ce1002.s103403513;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class Controller {
    @FXML
    private Canvas canvas;

    private GameManager gameManager;
    private AnimationTimer animationTimer;

    @FXML
    private void initialize(){
        gameManager = new GameManager(canvas.getGraphicsContext2D ());// initialize the GameManager
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                // clear the canvas to repaint on the canvas.
                canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gameManager.draw(timestamp);
            }
        };
        animationTimer.start();
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                gameManager.OnClick(event);
            }
        });
    }

    public void setScene(Scene scene){
        scene.setOnKeyPressed ( new EventHandler<KeyEvent>() {
            @Override
            public void handle ( KeyEvent event ) {
                if(event.getCode() == KeyCode.UP){
                    gameManager.movePlayerY(-1);
                }else if(event.getCode() == KeyCode.DOWN){
                    gameManager.movePlayerY(1);
                }else if(event.getCode() == KeyCode.LEFT){
                    gameManager.movePlayerX(-1);
                }else if(event.getCode() == KeyCode.RIGHT){
                    gameManager.movePlayerX(1);
                }
            }
        } );
        scene.setOnKeyReleased ( new EventHandler<KeyEvent>() {
            @Override
            public void handle ( KeyEvent event ) {
                if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN){
                    gameManager.movePlayerY(0);
                }else if(event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT){
                    gameManager.movePlayerX(0);
                }
            }
        } );
    }

}
