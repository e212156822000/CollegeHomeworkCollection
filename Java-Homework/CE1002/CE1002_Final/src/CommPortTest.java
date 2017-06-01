import jssc.SerialPort; import jssc.SerialPortException;

/** * * @author scream3r */ 
public class CommPortTest {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    SerialPort serialPort = new SerialPort("COM6");
    try {
        System.out.println("Port opened: " + serialPort.openPort());
        System.out.println("Params setted: " + serialPort.setParams(9600, 8, 1, 0));
        System.out.println("\"Hello World!!!\" successfully writen to port: " + serialPort.writeBytes("Hello World!!!".getBytes()));
        System.out.println("Port closed: " + serialPort.closePort());
    }
    catch (SerialPortException ex){
        System.out.println(ex);
    }
}
}