
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class LedTest extends Application {
    
    SerialPort arduinoPort = null;
    ObservableList<String> portList;
    
    ToggleButton tbLED13;
    Label labelValue;
    final int NUM_OF_POINT = 50;
    XYChart.Series series;
     
    private void detectPort(){
         
        portList = FXCollections.observableArrayList();
 
        String[] serialPortNames = SerialPortList.getPortNames();
        for(String name: serialPortNames){
            System.out.println(name);
            portList.add(name);
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        labelValue = new Label();
        labelValue.setFont(new Font("Arial", 28));
        
        detectPort();
        final ComboBox comboBoxPorts = new ComboBox(portList);
        comboBoxPorts.valueProperty()
                .addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, 
                    String oldValue, String newValue) {

                System.out.println(newValue);
                disconnectArduino();
                connectArduino(newValue);
                
                tbLED13.setSelected(false);
            }

        });
        
        //Toggle Button to control LED on Arduino 
        tbLED13 = new ToggleButton("Arduino LED 13");
        tbLED13.setOnAction((ActionEvent event) -> {
            updateLED13();
        });
        
        //LineChart
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Voltage");
        
        final LineChart<Number,Number> lineChart = 
                new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("Arduino Uno A0 Analog Input");
        series = new XYChart.Series();
        series.setName("A0 analog input");
        lineChart.getData().add(series);
        lineChart.setAnimated(false);
        
        //pre-load with dummy data
        for(int i=0; i<NUM_OF_POINT; i++){
            series.getData().add(new XYChart.Data(i, 0));
        }
        //
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(
                comboBoxPorts,  
                tbLED13, 
                labelValue, 
                lineChart);
        
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        
        Scene scene = new Scene(root, 500, 400);
        
        primaryStage.setTitle(
                "arduino-er.blogspot.com: Java + JavaFX + jSSC demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void updateLED13(){
        try {
            if(tbLED13.isSelected()){
                if(arduinoPort != null){
                    arduinoPort.writeString("On");
                    System.out.println("LED 13 ON");
                }else{
                    System.out.println("arduinoPort not connected!");
                }
            }else {
                if(arduinoPort != null){
                    arduinoPort.writeString("Off");
                    System.out.println("LED 13 OFF");
                }else{
                    System.out.println("arduinoPort not connected!");
                }
            }
        }catch (SerialPortException ex) {
            Logger.getLogger(LedTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    public void shiftSeriesData(float newValue)
    {
        for(int i=0; i<NUM_OF_POINT-1; i++){
            XYChart.Data<String, Number> ShiftDataUp = 
                    (XYChart.Data<String, Number>)series.getData().get(i+1);
            Number shiftValue = ShiftDataUp.getYValue();
            XYChart.Data<String, Number> ShiftDataDn = 
                    (XYChart.Data<String, Number>)series.getData().get(i);
            ShiftDataDn.setYValue(shiftValue);
        }
        XYChart.Data<String, Number> lastData = 
            (XYChart.Data<String, Number>)series.getData().get(NUM_OF_POINT-1);
        lastData.setYValue(newValue);
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
                    try {
                        
                        byte[] b = serialPort.readBytes();
                        int value = b[0] & 0xff;    //convert to int
                        String st = String.valueOf(value);

                        //Update label in ui thread
                        Platform.runLater(() -> {
                            labelValue.setText(st);
                            shiftSeriesData((float)value * 5/255); //in 5V scale
                        });
                        
                    } catch (SerialPortException ex) {
                        Logger.getLogger(LedTest.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                    
                }
            });
            
            arduinoPort = serialPort;
            success = true;
        } catch (SerialPortException ex) {
            Logger.getLogger(LedTest.class.getName())
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
                Logger.getLogger(LedTest.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void stop() throws Exception {
        disconnectArduino();
        super.stop();
    }
            
    public static void main(String[] args) {
        launch(args);
    }
    
}
