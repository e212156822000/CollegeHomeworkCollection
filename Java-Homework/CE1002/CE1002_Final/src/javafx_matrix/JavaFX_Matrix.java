package javafx_matrix;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class JavaFX_Matrix extends Application {
    
    final private int NUM_X = 8;
    final private int NUM_Y = 8;
    
    SerialPort arduinoPort = null;
    ObservableList<String> portList;

    @Override
    public void start(Stage primaryStage) {
        
        //ComboBox for port selection
        detectPort();
        final ComboBox<String> comboBoxPorts = new ComboBox<String>(portList);
        comboBoxPorts.valueProperty()
                .addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, 
                    String oldValue, String newValue) {

                System.out.println(newValue);
                disconnectArduino();
                connectArduino(newValue);
            }

        });
        
        
        
        final Label label = new Label("arduino-er.blogspot.com");
        label.setFont(Font.font("Arial", 24));
        
        Button btnExit = new Button("Exit");
        btnExit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        VBox vBoxInfo = new VBox();
        vBoxInfo.getChildren().addAll(label, btnExit);
        
        //Matrix of RadioButton
        VBox vBoxMatrix = new VBox();
        vBoxMatrix.setPadding(new Insets(10, 10, 10, 10));

        for(int y=0; y<NUM_Y; y++){
            HBox box = new HBox();
            for(int x=0; x<NUM_X; x++){
                MatrixButton btn = new MatrixButton(x, y);
                box.getChildren().add(btn);
            }
            vBoxMatrix.getChildren().add(box);
            
        }
        
        vBoxMatrix.widthProperty().addListener(new ChangeListener<Number>(){

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                comboBoxPorts.setPrefWidth((double)newValue);
                btnExit.setPrefWidth((double)newValue);
            }
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(comboBoxPorts);
        borderPane.setCenter(vBoxMatrix);
        borderPane.setBottom(vBoxInfo);

        Scene scene = new Scene(borderPane, 300, 250);

        primaryStage.setTitle("Arduino-er");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void stop() throws Exception {
        disconnectArduino();
        super.stop();
    }
    //¦C¦ncom portªí
    private void detectPort(){
         
        portList = FXCollections.observableArrayList();
 
        String[] serialPortNames = SerialPortList.getPortNames();
        for(String name: serialPortNames){
            System.out.println(name);
            portList.add(name);
        }
    }
    
    public boolean connectArduino(String port){
        
        System.out.println("connectArduino");
        
        boolean success = false;
        SerialPort serialPort = new SerialPort(port);
        try {
            serialPort.openPort();
            serialPort.setParams(
                    SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setEventsMask(MASK_RXCHAR);
            serialPort.addEventListener((SerialPortEvent serialPortEvent) -> {
                if(serialPortEvent.isRXCHAR()){            
                    //receive something for debug
                    try {
                        String st = serialPort.readString(serialPortEvent
                                .getEventValue());
                        System.out.println(st);
                        
                    } catch (SerialPortException ex) {
                        Logger.getLogger(JavaFX_Matrix.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            
            arduinoPort = serialPort;
            
            //Send dummy to clear buffer
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(JavaFX_Matrix.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
            sendDotArduino(0, 0, false);
            
            success = true;
        } catch (SerialPortException ex) {
            Logger.getLogger(JavaFX_Matrix.class.getName())
                    .log(Level.SEVERE, null, ex);
            System.out.println("SerialPortException: " + ex.toString());
        }

        return success;
    }
    
    public void disconnectArduino(){
        
        System.out.println("disconnectArduino()");
        if(arduinoPort != null){
            try {
                arduinoPort.removeEventListener();
                
                if(arduinoPort.isOpened()){
                    arduinoPort.closePort();
                }
                
                arduinoPort = null;
            } catch (SerialPortException ex) {
                Logger.getLogger(JavaFX_Matrix.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void sendDotArduino(int x, int y, boolean s){
        final byte SYNC_WORD = (byte)0xFF;
        if(arduinoPort != null){
            byte[] buffer = new byte[]{
                SYNC_WORD,
                (byte)x, 
                (byte)y, 
                (byte)(s ? 1 : 0)
            };

            try {
                arduinoPort.writeBytes(buffer);
            } catch (SerialPortException ex) {
                Logger.getLogger(JavaFX_Matrix.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class MatrixButton extends RadioButton {

        public MatrixButton(int x, int y) {
            
            setOnAction((ActionEvent event) -> {
                
                RadioButton src = (RadioButton) event.getSource();    
                JavaFX_Matrix.this.sendDotArduino(x, y, src.isSelected());
                
            });
        }
    }

}
