package semesterprojekt2ekg;

import java.util.*;

public class DataBehandler {

    private static Timer timer = new Timer(true);
    private String rawData;
    private int[] intarray;
    private List<Integer> samlet = new ArrayList<Integer>();
    private int taeller = 0;
    private double puls;
    private Arkiv db;

    //Sensor forb = new Sensor();
    DataBehandler(Arkiv a) {
        db = a;
    }
    
    /*getData*/
    public void setArray() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                rawData = db.Download();
                //vi ændrer nu vores string array til et int array
                    String[] deltrettet = rawData.split(",");
                    intarray = new int[deltrettet.length];

                    for (int i = 0; i < deltrettet.length; i++) {

                        intarray[i] = Integer.parseInt(deltrettet[i]);  //***OBS: NumberFormatException nogle gange!!!***

                    }
                setPuls();
            }
        }, 0, 1000);
    }

    public void dataSamler() {
       /* System.out.println("Samlermani: " + Arrays.toString(rawData));
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
        }*/
    }

    public void setPuls() {
                //pulsberegner
    }

    public double getPuls() {
        //returner den beregnet puls værdi
        return puls;
    }

    public void filter() {
        //måske noget filter
    }

}
