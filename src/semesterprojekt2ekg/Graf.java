package semesterprojekt2ekg;

import java.awt.*;
import static java.awt.Color.*;
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
        
        Graphics2D g2 = (Graphics2D) g;
        
        int origoX = 55;
        int origoY = 405;
        int x = origoX; //Første x-koordinat, stiger gennem iterationer.
         //Første y-koordinat, stiger gennem iterationer.
        int gx = 35; //gammel x-koordinat
        int gy = 405; //gammel y-koordinat
        
        for(int i = 0; i<grafData.length; i++){
            int y = (grafData[i]);
            
            // Tegning af værdierne i grafen (kun heltal)
           
            
            g2.setColor(blue);
            
            //Hvis der kun er en måling tegnes ét rektangel.
            if(i > 0 && grafData.length == 1){
                g2.drawRect(x, y, 2, 2);
            }
            
            //Hvis der er mere end en måling tegnes streger.
            if(i > 0 && grafData.length > 1){
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(gx, gy, x, y);
            }
            gx = x;
            gy = y;
            
            
            x+= 1;
            
            //Så der ikke tegnes ude for det hvide rektangel.
            if(i == 1251){ 
                break;
            }
        }
        
        
        
    }    
}
