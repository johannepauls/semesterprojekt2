package semesterprojekt2ekg;

import java.util.*;
import javax.swing.JPanel;

public class Graf extends JPanel {

    private Arkiv db;
    private static Timer timer = new Timer(true);
    private ArrayList<Integer> dataFromDownload;

    public Graf(Arkiv a) {
        db = a;
        setData();
    }
    
    private void setData() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                do{
                dataFromDownload = db.Download();
                }while(dataFromDownload == null);
            }
        }, 0, 1000);
    }

    public void tegnGraf() {
        //tegner graf over dataSamlet
    }
}
