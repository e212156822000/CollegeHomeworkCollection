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

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
import javafx.scene.paint.Color;


public class Piano extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/piano.fxml"));
        PianoController controller = new PianoController ();
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        //get piano keyboard
        Group group = controller.getKeyBoard();
    	group.getChildren().add(root);
    	Scene piano = new Scene (group);
    	
    	piano.setFill(Color.GRAY);
        primaryStage.setTitle("Fx Piano");
        primaryStage.setScene(piano);
        controller.setScene(piano);
        primaryStage.show();
        
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}

