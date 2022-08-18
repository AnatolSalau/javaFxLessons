package by.salov.comport;
import jssc.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComPortJSSCService {

    private String[] comPortNames;

    public ComPortJSSCService() {
        this.comPortNames = SerialPortList.getPortNames();
    }

    public SerialPort getComPortByName (String comPortName) {
        SerialPort serialPort = new SerialPort(comPortName);
        return serialPort;
    }
}
