package semesterprojekt2ekg;

import java.util.*;
import javax.swing.JPanel;

public class Graf extends JPanel {

    private Arkiv db;
    private static Timer timer = new Timer(true);
    private int[] dataFromDownload;
    private ArrayList<int[]> dataSamlet = new ArrayList<int[]>();

    public Graf(Arkiv a) {
        db = a;
    }
    
    public void setData() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                dataFromDownload = db.Download();
                dataSamlet.add(dataFromDownload);
                
                dataSamlet.remove(0);
            }
        }, 0, 1000);
    }

    public void tegnGraf() {
        //tegner graf over dataSamlet
    }
}
