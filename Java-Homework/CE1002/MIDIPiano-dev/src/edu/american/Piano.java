   /*Copyright 2013 Meredith Myers

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.*/

package edu.american;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;


import edu.american.Controller;

/* BONUS WORK:
 * Added a JComboBox for instrument selection.
 * Added a JTextArea for tempo.
 * Added a help window.
 * Made the repeat song a JTextArea so the user is not limited to 10 repeats.
 * Added the black keys.
 * Added a custom color.*/

/** Constructs the GUI and handles user interaction.
 * @author Meredith Myers
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jfugue.player.Player;

public class Piano extends Application {
	private int Music_Scale = 3;
    private int Num_Keys = 7;
    private String[] keys = {"C","D","E","F","G","A","B"};
    private String[] octave = {"4","5","6"};
    private Player player = new Player();
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/piano.fxml"));
        Controller controller = new Controller ();
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        
        Group group = new Group();
        HBox box = new HBox(3);
        box.setPadding(new Insets(50, 12, 15, 12));
        
        int x = 0;
    	int y = 0;
    	
    	for(int i = 0;i < Music_Scale ; i++){
    		for(int j = 0;j< Num_Keys ;j++){
    			/*
    			if(j!=0 && j!=3){
    				ImageView imageView2 = new ImageView(new Image("images/blackKey.png"));
    				box.getChildren().add(imageView2);
    				imageView2.setX(x);
    				imageView2.setY(y);
    			}
    			*/
    			final ImageView imageView = new ImageView(new Image("images/"+keys[j]+".png"));
    			imageView.setId(keys[j]+octave[i]);
    	        box.getChildren().addAll(imageView);
    	        imageView.setOnMouseClicked(new EventHandler<MouseEvent>(){

					@Override
					public void handle(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
						player.play(imageView.getId());
						System.out.println(imageView.getId());
					}
    	        });
    		}
    	}
    	group.getChildren().add(box);
    	group.getChildren().add(root);
    	Scene piano = new Scene (group);
    	piano.setFill(Color.GRAY);
        primaryStage.setTitle("Fx Piano");
        
        piano.getStylesheets().add("piano.css");
        controller.setScene ( piano );
        primaryStage.setScene( piano);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

