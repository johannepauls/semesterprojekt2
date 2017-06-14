package semesterprojekt2ekg;

import java.util.*;

public class Queue {

    private double[] queueArray = new double[250];

    private String partString;

    /*tilføjer et array med data fra sensoren til en kø
    *kø er en arraylist af int-arrays*/
    public synchronized void addToQueue(double[] filtValues) {
        queue
        
        
    }

    /*henter et array fra køren, hvis køen ikke er tøm
    *OBS hvor tager den fra og hvor bliver nye data lagt ind?*/
    public synchronized String processQueue() {
        if (!isQueueArray()) {
            partString = queueArray.get(0);
            queueArray.remove(0);
        }
        return partString;
    }

    public synchronized double[] processFiltQueue() {
        if (!isFiltQueueArray()) {
            partArray = filtQueueArray.get(0);
            filtQueueArray.remove(0);
        }
        return partArray;
    }

    /*boolsk værdi der gør det muligt at tjekke om køen er tøm
    *kaldes fra Arkiv-klassen*/
    public boolean isQueueArray() {
        return queueArray.isEmpty();
    }

    public boolean isFiltQueueArray() {
        return filtQueueArray.isEmpty();
    }
}
