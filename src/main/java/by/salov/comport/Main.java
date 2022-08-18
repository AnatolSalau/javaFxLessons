package by.salov.comport;



import com.fazecast.jSerialComm.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortTimeoutException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ComPortJComService comPortJComService = new ComPortJComService();
        SerialPort[] serialPorts = comPortJComService.getSerialPorts();
        try
        {
            for (int i = 0; i < serialPorts.length; i++) {
                serialPorts[i].closePort();
                System.out.println(serialPorts[i].getSystemPortName());
                System.out.println(serialPorts[i].getPortDescription());
                serialPorts[i].openPort();
                serialPorts[i].setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
                System.out.println(serialPorts[i].isOpen());
                System.out.println();
                serialPorts[i].closePort();
            }
        } catch (Exception e) { e.printStackTrace(); }

        ComPortJSSCService comPortJSSCService = new ComPortJSSCService();
        jssc.SerialPort com4 = comPortJSSCService.getComPortByName("COM4");
        try {
            com4.openPort();
            com4.setParams(9600, 8, 1, 0);

           System.out.println("read 10 bytes ");
            byte[] bytes = com4.readBytes(10);
            System.out.println(bytes);
            for (int i = 0; i < bytes.length; i++) {
                System.out.println(bytes[i]);
            }
            System.out.println("Write {'C', 'L', 'B', 'Ž', 'E'}");
            char[] chars = {'C', 'L', 'B', 'Ž', 'E'};
            for (int i = 0; i < chars.length; i++) {
                System.out.println((byte)chars[i]);
                com4.writeByte((byte)chars[i]);
            }
            System.out.println("Read 50 bytes");
            byte[] bytes2 = com4.readBytes(50);
            for (int i = 0; i < bytes2.length; i++) {
                System.out.println(bytes2[i]);
            }
            com4.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }

    }
}
