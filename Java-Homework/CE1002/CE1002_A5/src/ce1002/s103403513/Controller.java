package ce1002.s103403513;
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
    private ImageView buttonImage;
    @FXML
    private Button switchButton;
    private int i = 1;
    @FXML
    private void initialize() {
    	
        buttonImage.setImage ( new Image ("/image/player.png") );
        switchButton.setOnAction ( new EventHandler<ActionEvent> () {
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
                    buttonImage.setTranslateY ( buttonImage.getTranslateY () - 10 );
                }
                if(event.getCode() == KeyCode.DOWN) {
                    buttonImage.setTranslateY ( buttonImage.getTranslateY () + 10 );
                }
                if(event.getCode() == KeyCode.LEFT) {
                    buttonImage.setTranslateX ( buttonImage.getTranslateX () - 10 );
                }
                if(event.getCode() == KeyCode.RIGHT) {
                    buttonImage.setTranslateX ( buttonImage.getTranslateX () + 10 );
                }
                if(event.getCode() == KeyCode.X) {
                    buttonImage.setRotate ( buttonImage.getRotate () + 10*i );
                }
            }
        } );
    }
}
