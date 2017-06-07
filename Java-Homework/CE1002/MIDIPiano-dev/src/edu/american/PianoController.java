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
import javafx.geometry.Pos;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
    @FXML
    private Pane pane;
    private int Music_Scale = 3;
    private int Num_Keys = 7;
    private String[] white_keys = {"C","D","E","F","G","A","B"};
    private String[] black_keys = {"","C#","D#","","F#","G#","A#"};
    private String[] octave = {"4","5","6"};
    private Player player = new Player();
    private String[] levels = {"Easy","Normal","Hard","Nightmare"};
    private boolean Repeat_chance = true;
    private int in_level = 0;
    private int thread_id = 1;
    DropShadow ds = new DropShadow( 20, Color.GOLDENROD );
    MusicController mc = new MusicController();
    private Stage stage;
    @FXML
    private void initialize() {
    	PlayButton.setText("開始彈奏");
    	RetryButton.setText("重新播放");
    	RetryButton.setOnAction(e -> ReplaySong(e,levels[in_level]));
    	level.setFont(new Font(50));
    	status.setFont(new Font(30));
    }
    
    public void setScene(Scene scene){
    	//關卡一
    	//SetLevels(levels[in_level]);
    	stage = (Stage) PlayButton.getScene().getWindow();
    	
    	scene.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				SetLevels(levels[in_level]);
				scene.setOnMouseClicked(null);
			}
    		
    	});
    }
    
    public Group getKeyBoard(){
    	Group group = new Group();
        StackPane stackpane = new StackPane();
        HBox PainoPanel = new HBox(3);
        PainoPanel.setPadding(new Insets(400, 12, 12, 12));
        
        int x = 0;
    	int y = 0;
    	
    	for(int i = 0;i < Music_Scale ; i++){
    		for(int j = 0;j< Num_Keys ;j++){
    			final ImageView imageView = new ImageView(new Image("images/"+white_keys[j]+".png"));
    			imageView.setId(white_keys[j]+octave[i]);
    			imageView.setOnMouseClicked(e->ButtonClicked(e));
    			PainoPanel.getChildren().add(imageView);
    		}
    	}
    	stackpane.getChildren().add(PainoPanel);
    	
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
    	//get imageView's id
    	ImageView imageView = (ImageView)e.getSource();
    	String ActionId = imageView.getId();
    	PreviousClicked.setEffect(null);
    	imageView.setEffect(ds);
    	mc.PutSongInPlayer(ActionId);
    	PreviousClicked = imageView;
	}
    
    /*
     * 
     * 
    	MusicController PreviousClickedMc = new MusicController();
    	try{
    		PreviousClickedMc.join();
        }catch( Exception exp){
        	System.out.println("error");
        }
        
    	MusicController mc_key = new MusicController();
    	Thread.currentThread().setName(ActionId+thread_id);
    	PreviousClickedMc = mc;
    	thread_id ++;
    	
     */
    private void SetLevels(String Level){
    	
    	if(Level.equals("Easy")){
    		level.setText("第一關");
    		status.setText("播放歌曲中...");
    		mc.PickSong(Level);
    		mc.start();
    	}
    	
    }
    private void ReplaySong(Event e,String WhichSong){
    	Button btn = (Button)e.getSource();
    	mc.PutSongInPlayer(WhichSong);
    }
}
