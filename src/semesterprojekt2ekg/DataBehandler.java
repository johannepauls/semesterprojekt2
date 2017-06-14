package semesterprojekt2ekg;

import java.util.*;

public class DataBehandler {

    private String rawData;
    private int[] dataFromDownload;
    private List<Integer> samlet = new ArrayList<Integer>();
    private int taeller = 0;
    private double puls = 0;
    private Arkiv db;
    private int a;

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
    
    public double[] filter(int[] unfiltInt) {

        //Implementation af filterkoefficienter.
        double[] coeff = {0.000192642670559929, -0.000295969341969912, -0.0159646050723928, -0.00141767205494229, 0.00495873534467181, 0.00492932912433127, -0.00143829785398881, -0.00412229652150344, -0.000725583496722631, 0.00118222316646138, -0.000493620065620664, 0.00117486041703018, 0.00596748357539415, 0.00280771876672282, -0.00887378244319598, -0.0109860974401662, 0.00516533462288644, 0.0183028286541792, 0.00622757120682425, -0.0162677482910494, -0.0162498459104114, 0.00615499706861166, 0.0175965568532649, 0.00462707138156552, -0.00813217121457955, -0.00387900351447397, -0.000240686581763361, -0.00855394505719800, -0.00509685654838130, 0.0213134779323662, 0.0291943825744723, -0.0140579514651684, -0.0562947380890519, -0.0204999499794175, 0.0624818572848815, 0.0703033812156306, -0.0293789880659520, -0.103472656048910, -0.0339767809951856, 0.0940287556341654, 0.0973049963592231, -0.0376970246354199, 0.876791146211192, -0.0376970246354199, 0.0973049963592231, 0.0940287556341654, -0.0339767809951856, -0.103472656048910, -0.0293789880659520, 0.0703033812156306, 0.0624818572848815, -0.0204999499794175, -0.0562947380890519, -0.0140579514651684, 0.0291943825744723, 0.0213134779323662, -0.00509685654838130, -0.00855394505719800, -0.000240686581763361, -0.00387900351447397, -0.00813217121457955, 0.00462707138156552, 0.0175965568532649, 0.00615499706861166, -0.0162498459104114, -0.0162677482910494, 0.00622757120682425, 0.0183028286541792, 0.00516533462288644, -0.0109860974401662, -0.00887378244319598, 0.00280771876672282, 0.00596748357539415, 0.00117486041703018, -0.000493620065620664, 0.00118222316646138, -0.000725583496722631, -0.00412229652150344, -0.00143829785398881, 0.00492932912433127, 0.00495873534467181, -0.00141767205494229, -0.0159646050723928, -0.000295969341969912, 0.000192642670559929};
        
        //Konvertering af int-arraylist til double-arraylist.
        double[] unfiltDouble = new double[unfiltInt.length];
        
        for(int i = 0; i < unfiltInt.length; i++){
            unfiltDouble[i] = unfiltInt[i];
        }
        
        //Foldning af data og filterkoefficienter.
        
        double[] filtECG = new double[unfiltInt.length];
        //i det her tilfælde y(n) = ...h(k) * x(h-k)
        for(int n = 0; n < filtECG.length; n++){
            
            for(int k = 0; k < coeff.length; k++){
                if(n < k){ a=0; } else a=n-k;
                filtECG[n] = filtECG[n] + (coeff[k]*unfiltDouble[n]);
                
            }
                
        }
        
        //Return
        return filtECG;
    }
    
    public void setPuls() {
        //pulsberegner
    }

    public double getPuls() {
        //returner den beregnet puls værdi
        return puls;
    }



}
