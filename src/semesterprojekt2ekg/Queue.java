package semesterprojekt2ekg;

import java.util.*;

public class Queue {

    private ArrayList<int[]> queueArray = new ArrayList<int[]>();
    private int[] partArray;

    /*tilføjer et array med data fra sensoren til en kø
    *kø er en arraylist af int-arrays*/
    public void addToQueue(int[] valueArray) {
        queueArray.add(valueArray);
    }

    /*henter et array fra køren
    *OBS hvor tager den fra og hvor bliver nye data lagt ind?*/
    public int[] processQueue() {
        if (!isQueueArray()) {
            partArray = queueArray.get(0);
        }
        return partArray;
    }

    public boolean isQueueArray() {
        return queueArray.isEmpty();
    }

}
