package semesterprojekt2ekg;

public class PulseBehandler {

    private double puls;
    private DataBehandler db;
    
    PulseBehandler(DataBehandler d){
        db = d; 
    }
    
    public void setPuls() {
        
    }

    public double getPuls() {
        //returner den beregnet puls værdi
        return puls;
    }

}
