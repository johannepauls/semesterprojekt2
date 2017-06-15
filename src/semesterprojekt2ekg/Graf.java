package semesterprojekt2ekg;

import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;

public class Graf extends JPanel {

    private Arkiv db;
    private static Timer timer = new Timer(true);
    private int[] dataFromDownload;
    private int[] grafData;

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
        grafData = tegnData;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        //henter data
        tegnGraf(dataFromDownload);
        
        super.paintComponent(g);
        
        
        
        
        
    }    
}
