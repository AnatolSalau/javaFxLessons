package by.salov.comport;



import com.fazecast.jSerialComm.SerialPort;
import jssc.SerialPortException;

import java.io.IOException;

public class Main_JSSC {
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
            for (int i = 0; i < bytes.length; i++) {
                System.out.println(bytes[i]);
            }

            System.out.println("Write {67, 76, 66, 142, 69 }");

            int[] ints = {67, 76, 66, 142, 69 };


            com4.writeIntArray(ints);

            //-------------------------------------------------
            System.out.println("Read 10 bytes");
            byte[] bytes2 = com4.readBytes(10);
            for (int i = 0; i < bytes2.length; i++) {
                System.out.println(Byte.toUnsignedInt(bytes2[i]));
            }
            //-------------------------------------------------
            System.out.println("Write {67, 76, 66, 142, 69 }");
            System.out.println("Like hex {43, 4C, 42, 8E, 45 }");
            String[] arrString = {"43","4C","42","8E","45"};
            int[] arrIntFromHex = new int[arrString.length];
            for (int i = 0; i < arrString.length; i++) {
                arrIntFromHex[i] = Integer.parseInt(arrString[i],16);
            }
            com4.writeIntArray(arrIntFromHex);
            //-------------------------------------------------
            System.out.println("Read 10 bytes");
            byte[] bytes3 = com4.readBytes(10);
            for (int i = 0; i < bytes2.length; i++) {
                System.out.println(Byte.toUnsignedInt(bytes2[i]));
            }
            com4.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }

    }
}
