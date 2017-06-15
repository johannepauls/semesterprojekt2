package semesterprojekt2ekg;

import java.util.*;
import javax.swing.JPanel;

public class Graf extends JPanel {

    private Arkiv db;
    private static Timer timer = new Timer(true);
    private int[] dataFromDownload;

    public Graf(Arkiv a) {
        db = a;
        setData();
    }
    
    private void setData() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                int[] data = db.Download();
                if(data != null){
                    dataFromDownload = data;
                }
            }
        }, 0, 1000);
    }

    public void tegnGraf(int[] tegnData) {
        //tegner graf over dataSamlet
    }
}
