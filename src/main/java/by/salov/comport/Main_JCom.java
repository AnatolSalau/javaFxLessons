package by.salov.comport;

import com.fazecast.jSerialComm.SerialPort;

public class Main_JCom {
    public static void main(String[] args) {
        ComPortJComService comPortJComService = new ComPortJComService();
        SerialPort glucoBridge = comPortJComService.getComPortByDescription("GlucoBridge");

        glucoBridge.openPort();
        System.out.println(glucoBridge.isOpen());


        glucoBridge.closePort();
        System.out.println(glucoBridge.isOpen());
    }
}
