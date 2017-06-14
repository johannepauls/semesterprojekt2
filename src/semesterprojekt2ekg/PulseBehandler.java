package semesterprojekt2ekg;

public class PulseBehandler {

    private double puls;
    private Arkiv db;
    
    PulseBehandler(Arkiv a){
        db = a; 
    }
    
    public void setPuls() {
        
    }

    public double getPuls() {
        //returner den beregnet puls værdi
        return puls;
    }

}
