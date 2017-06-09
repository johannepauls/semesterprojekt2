package semesterprojekt2ekg;

import java.util.*;

public class DataBehandler {

    int rawData[];
    List<Integer> samlet = new ArrayList<Integer>();
    int taeller = 0;
    private double puls;

    //Sensor forb = new Sensor();
    DataBehandler() {

    }

    public void setData(int intarray[]) {
        rawData = intarray;

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
        //puls beregner

    }

    public double getPuls() {
        //returner den beregnet puls værdi
        return puls;
    }

    public void filter() {
        //måske noget filter
    }

}
