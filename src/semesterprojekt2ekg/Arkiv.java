package semesterprojekt2ekg;

import java.sql.*;
import java.util.Arrays;

public class Arkiv implements Runnable {

    private Queue ko;
    private int[] value;
    private int[] data;

    public Arkiv(Queue q) {
        ko = q;
        /*Opret forbindelse til */
    }

    @Override
    public void run() {
        for (;;) {
            if (!ko.isQueueArray()) {
                value = ko.processQueue();
                //System.out.println("virker det?" + Arrays.toString(value));
                /*Indsæt i databasen*/
            }
        }
    }

    public int[] Download() {
        //hent data fra databasen

        /*TEST value - rigtigt: data*/
        return value;
    }
}
