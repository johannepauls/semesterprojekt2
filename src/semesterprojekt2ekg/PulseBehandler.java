package semesterprojekt2ekg;

import java.util.ArrayList;

public class PulseBehandler {

    private int puls;
    private Arkiv db;
    private int[] filtData;
    private int startTime = 0;
    private int endTime;
    private int diffTime;
    
    
    PulseBehandler (Arkiv database){
        db = database; 
        filtData = database.Download();
        
        for(int i = 0; i < filtData.length; i++){
            if(filtData[i] > filtData[i-1] && filtData[i] < 300){
                endTime = (int) System.currentTimeMillis();
                
                diffTime = endTime - startTime;
                
                puls = Math.round(60000/diffTime);
                
                endTime = startTime;
            }
        }
    }
    

    public double getPuls() {
        //returner den beregnet puls værdi
        return puls;
    }

}
