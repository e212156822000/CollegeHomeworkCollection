package crazy_pianist;
import javax.sound.midi.MidiUnavailableException;

import javafx.animation.FadeTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
public class PianoController {
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
    private String[] levels = {"Easy","Normal","Hard","Success"};
    private int in_level = 0;
    private String AnswerMusic = "";
    DropShadow ds = new DropShadow( 20, Color.GOLDENROD );
    MusicController mc = new MusicController();
    private StackPane stackpane = new StackPane();
    private Stage stage;
    private FadeTransition fadeIn = new FadeTransition(Duration.millis(8000));
    @FXML
    private void initialize() {
    	//���� Retrybutton �קK�~�ɪ��a�C
    	RetryButton.setText("���s����");
    	RetryButton.setOnAction(e -> ReplaySong(e));
    	RetryButton.setVisible(false);
    	level.setFont(new Font(50));
    	status.setFont(new Font(20));
    	level.setMaxWidth(Double.MAX_VALUE);
    	level.setAlignment(Pos.TOP_CENTER);
    	status.setAlignment(Pos.TOP_CENTER);
    	level.setText("�C������");
    	status.setText("    �C�����C�@�����|���@�q�۫ߡA\n���a�u�n�̾ڦۤv�����P�A���\�u\n�X���T���۫ߡA�N�i�H�L���C����\n�����N�B�Y�i�}�l�C���C");
    	level.setTextFill(Color.WHITE);
		status.setTextFill(Color.WHITE);
        fadeIn.setNode(status);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.playFromStart();
		stackpane.setStyle("-fx-background-image: url('images/sky_fit.jpg')");
    }
    public void setScene(Scene scene) throws MidiUnavailableException{
    	//��l�����d�@
    	stage = (Stage) level.getScene().getWindow();
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
        
        HBox PainoPanel = new HBox(3);
        PainoPanel.setPadding(new Insets(400, 12, 12, 12));
        
        int x = 0,y = 0;
      
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
    	mc.PutKeyInPlayer(ActionId);
    	mc.PlayMusic();
    	PreviousClicked.setEffect(null);
    	imageView.setEffect(ds);
    	PreviousClicked = imageView;
    	AnswerMusic += ActionId + " ";
    	
    	if(mc.CheckAnswer(AnswerMusic)){
    		System.out.println("win!");
    		mc.pass = false;
    		SetLevels(levels[++in_level]);
    	}
	}
	private void SetLevels(String Level){
		RetryButton.setVisible(true);
    	if(Level.equals("Easy")){
    		level.setText("�Ĥ@��");
    		mc.PickSong(Level);
        	status.setText("����q���G"+mc.getTestSongName());
        	mc.PlayMusic();
    	}else if(Level.equals("Normal")){
    		level.setText("�ĤG��");
    		level.setTextFill(Color.GRAY);
    		status.setTextFill(Color.GRAY);
    		//ds = new DropShadow( 20, Color.GREEN );
    		stackpane.setStyle("-fx-background-image: url('images/city_fit.jpg')");
    		mc.PickSong(Level);
        	status.setText("����q���G"+mc.getTestSongName());
        	mc.PlayMusic();
    	}else if(Level.equals("Hard")){
    		level.setText("�ĤT��");
    		stackpane.setStyle("-fx-background-image: url('images/forest_fit.jpg')");
    		mc.PickSong(Level);
        	status.setText("����q���G"+mc.getTestSongName());
        	mc.PlayMusic();
    	}else{
    		level.setText("���߹L��");
    		status.setText("@���e�ӷ�:���O�g\n");
    		fadeIn.setNode(status);
            fadeIn.setFromValue(0.0);
            fadeIn.setToValue(1.0);
            fadeIn.playFromStart();
    		level.setTextFill(Color.WHITE);
    		status.setTextFill(Color.WHITE);
    		RetryButton.setVisible(false);
    		stackpane.setStyle("-fx-background-image: url('images/fall_fit.jpg')");
    		mc.PutSongInPlayer(mc.getTestSongMelody());
        	mc.PlayMusic();
    	}
		
		mc.setTestSong(mc.SongFilter(mc.getTestSongMelody()));
		System.out.println(mc.getTestSong());
    }
    private void ReplaySong(Event e){
    	mc.PutSongInPlayer(mc.getTestSongMelody());
    	mc.PlayMusic();
    }
}