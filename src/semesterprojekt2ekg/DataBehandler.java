package semesterprojekt2ekg;

import java.util.*;

public class DataBehandler {

    private String rawData;
    private int[] dataFromDownload;
    private List<Integer> samlet = new ArrayList<Integer>();
    private int taeller = 0;
    private double puls = 0;
    private Arkiv db;

    //Sensor forb = new Sensor();
    DataBehandler(Arkiv a) {
        db = a;
    }

    /*getData*/
    public void getArray() {
        /*hvor eller hvordan skal denne klasse hente data til pulsberegning?*/
        dataFromDownload = db.Download();

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
    
    public void filter() {
        //Konvertering af int-arraylist til double-arraylist.
        
        //Implementation af filterkoefficienter.
        
        //Foldning af data og filterkoefficienter.
    }
    
    public void setPuls() {
        //pulsberegner
    }

    public double getPuls() {
        //returner den beregnet puls værdi
        return puls;
    }



}
