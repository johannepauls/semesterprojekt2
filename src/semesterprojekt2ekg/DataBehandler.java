package semesterprojekt2ekg;

import java.util.*;

public class DataBehandler implements Runnable {

    private static Timer timer = new Timer(true);
    int[] rawData;
    List<Integer> samlet = new ArrayList<Integer>();
    int taeller = 0;
    private double puls;
    private Arkiv db;

    //Sensor forb = new Sensor();
    DataBehandler(Arkiv a) {
        db = a;
    }

    /*getData*/
    public void run() {
        for (;;) {
            rawData = db.Download();
            //System.out.println("virker det?" + Arrays.toString(rawData));
        }
    }

    public void dataSamler() {
        System.out.println("Samlermani: " + Arrays.toString(rawData));
        for (int i = 0; i < rawData.length; i++) {
            samlet.add(rawData[i]);
            taeller++;
            System.out.println(taeller);
            if (taeller >= 300) {
                //gem samlet[]
                samlet.clear();
                System.out.println("Samlet[] er fuld: ");
            }
            System.out.println(rawData[i]);
        }
    }

    public void setPuls() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //pulsberegner
            }
        }, 0, 1000);
    }

    public double getPuls() {
        //returner den beregnet puls værdi
        return puls;
    }

    public void filter() {
        //måske noget filter
    }

}
