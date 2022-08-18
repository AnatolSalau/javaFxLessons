package by.salov.comport;

import com.fazecast.jSerialComm.SerialPort;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ComPortJComService {
    private SerialPort[] serialPorts;
    private Map<String,String> nameDescriptionMap;
    private  Map<String, SerialPort> descriptionPortMap;

    public ComPortJComService() {
        this.serialPorts = SerialPort.getCommPorts();
        nameDescriptionMap = new HashMap<>();
        this.nameDescriptionMap = getAllComPortNameDescriptionMap();
        descriptionPortMap = createDescriptionPortMap(serialPorts);
    }

    private Map<String,String> getAllComPortNameDescriptionMap() {
         Map<String,String> nameDescriptionMap = new HashMap<>();
        if (serialPorts.length == 0) {
            System.out.println("No ports found");
        } else {
            Arrays.stream(serialPorts)
                    .forEach(
                            serialPort -> {
                                String descriptivePortName = serialPort.getDescriptivePortName();
                                String portDescription = serialPort.getPortDescription();
                                nameDescriptionMap.put(descriptivePortName, portDescription);
                            }
                    );
        }
        return nameDescriptionMap;
    }
    public void printAllComPortNameDescriptionMap() {
        System.out.println("ComPorts:");
        nameDescriptionMap.entrySet().forEach(
                stringStringEntry -> {
                    System.out.println(
                            "Name : " + stringStringEntry.getKey() + " Description : " + stringStringEntry.getValue()
                    );
                }
        );
    }

    private Map<String, SerialPort> createDescriptionPortMap (SerialPort[] serialPorts) {
        Map<String, SerialPort> resultMap = new HashMap<>();
        Arrays.stream(serialPorts)
                .forEach(
                        serialPort -> {
                            String portDescription = serialPort.getPortDescription();
                            resultMap.put(portDescription, serialPort);
                        }
                );
        return resultMap;
    }
    public SerialPort getComPortByDescription (String description) {
        SerialPort serialPort = null;
        serialPort = descriptionPortMap.get(description);
        return serialPort;
    }

}
