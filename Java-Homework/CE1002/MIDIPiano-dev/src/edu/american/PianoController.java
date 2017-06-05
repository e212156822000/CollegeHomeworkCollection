package edu.american;
import java.io.File;
import java.util.Random;

import org.jfugue.player.Player;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class PianoController {
	@FXML
    private Button PlayButton;
    @FXML
    private Button RetryButton;
    @FXML
    private Label level;
    @FXML
    private Label status;
    
    private int Music_Scale = 3;
    private int Num_Keys = 7;
    private String[] white_keys = {"C","D","E","F","G","A","B"};
    private String[] black_keys = {"","C#","D#","","F#","G#","A#"};
    private String[] octave = {"4","5","6"};
    private Player player = new Player();
    private String[] levels = {"Easy","Normal","Hard","Nightmare"};
    private boolean Repeat_chance = true;
    private int in_level = 0;
    DropShadow ds = new DropShadow( 20, Color.AQUA );
    SongList songlist = new SongList();
    @FXML
    private void initialize() {
    	PlayButton.setText("開始彈奏");
    	RetryButton.setText("重新播放");
    	RetryButton.setOnAction(e -> ReplaySong(e,levels[in_level]));
    }
    public void setScene(Scene scene){
    	//關卡一
    	//SetLevels(levels[in_level]);
    }
    public Group getKeyBoard(){
    	Group group = new Group();
        StackPane stackpane = new StackPane();
        HBox box = new HBox(3);
        box.setPadding(new Insets(400, 12, 12, 12));
        
        int x = 0;
    	int y = 0;
    	
    	for(int i = 0;i < Music_Scale ; i++){
    		for(int j = 0;j< Num_Keys ;j++){
    			final ImageView imageView = new ImageView(new Image("images/"+white_keys[j]+".png"));
    			imageView.setId(white_keys[j]+octave[i]);
    			imageView.setOnMouseClicked(e->ButtonClicked(e));
    			box.getChildren().add(imageView);
    		}
    	}
    	stackpane.getChildren().add(box);
    	
    	for(int i = 0;i < Music_Scale ; i++){
    		for(int j = 0;j< Num_Keys ;j++){
    			if(j!=0 && j!=3){
    				ImageView imageView2 = new ImageView(new Image("images/blackKey.png"));
    				imageView2.setId(black_keys[j]+octave[i]);
    				imageView2.setTranslateX(x-408);
        			imageView2.setTranslateY(y+160);
        			imageView2.setOnMouseClicked(e->ButtonClicked(e));
        			stackpane.getChildren().add(imageView2);
        			x+=43;
    			}
    			else{
    				x+=30;
    			}
    		}
    	}
    	group.getChildren().add(stackpane);   	
    	return group;
    }
    ImageView PreviousClicked = new ImageView();
    private void ButtonClicked(MouseEvent e) {
    	ImageView imageView = (ImageView)e.getSource();
    	String ActionId = imageView.getId();
    	PreviousClicked.setEffect(null);
    	imageView.setEffect(ds);
    	player.play(ActionId);
    	PreviousClicked = imageView;
	}
    
    private void SetLevels(String Level){
    	if(Level.equals("Easy")){
    		level.setText("第一關");
    		String song = songlist.PickSong(Level);
    		System.out.println(song);
        	player.play(song);
    	}
    	
    	
    }
    private void ReplaySong(Event e,String TestSong){
    	Button btn = (Button)e.getSource();
    	
    	btn.setDisable(true);
    }
}
