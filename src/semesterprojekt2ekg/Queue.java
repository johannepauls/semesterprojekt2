package semesterprojekt2ekg;

import java.util.*;

public class Queue {

    private ArrayList<int[]> queueArray = new ArrayList<int[]>();

    private int[] partArray;

    /*tilføjer et array med data fra sensoren til en kø
    *kø er en arraylist af int-arrays*/
    public synchronized void addToQueue(int[] filtValues) {
        queueArray.add(filtValues);
        if (queueArray.size() == 1) {
            notify();
        }
    }

    /*henter et array fra køren, hvis køen ikke er tøm
    *OBS hvor tager den fra og hvor bliver nye data lagt ind?*/
    public synchronized int[] processQueue() {
        if (queueArray.size() < 1) {
            try {
                wait();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        partArray = queueArray.get(0);
        queueArray.remove(0);
        
        return partArray;
    }
}
