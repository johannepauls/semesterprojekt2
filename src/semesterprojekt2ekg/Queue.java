package semesterprojekt2ekg;

import java.util.*;

public class Queue {

    private ArrayList<String> queueArray = new ArrayList<String>();
    private String partString;

    /*tilføjer et array med data fra sensoren til en kø
    *kø er en arraylist af int-arrays*/
    public void addToQueue(String value) {
        queueArray.add(value);
    }

    /*henter et array fra køren, hvis køen ikke er tøm
    *OBS hvor tager den fra og hvor bliver nye data lagt ind?*/
    public String processQueue() {
        if (!isQueueArray()) {
            partString = queueArray.get(0);
        }
        return partString;
    }
    
    /*boolsk værdi der gør det muligt at tjekke om køen er tøm
    *kaldes fra Arkiv-klassen*/
    public boolean isQueueArray() {
        return queueArray.isEmpty();
    }

}
