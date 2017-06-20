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

                if (data != null) {
                    dataFromDownload = data;

                }
            }
        }, 0, 1000);
    }

    private void protectData(int[] tegnData) {
        grafData = tegnData;
    }

    public void tegnGraf(Graphics g) {
        protectData(dataFromDownload);

        Graphics2D g2 = (Graphics2D) g;

        int origoX = 56;
        int origoY = 405;
        int x = origoX; //Første x-koordinat, stiger gennem iterationer.
        //Første y-koordinat, stiger gennem iterationer.
        int gx = 35; //gammel x-koordinat
        int gy = 405; //gammel y-koordinat
        //System.out.println(""+ Arrays.toString(grafData));
        for (int i = 0; i < grafData.length; i++) {
            int yR = ((grafData[i]));
            int y = 65+(406-yR);
            
            if(y<0) y=0;
            //System.out.println(y);
            // Tegning af værdierne i grafen (kun heltal)
            g2.setColor(green);

            //Hvis der kun er en måling tegnes ét rektangel.
            if (i > 0 && grafData.length == 1) {
                g2.drawRect(x, y, 2, 2);
            }
            //Så der ikke tegnes ude for det hvide rektangel.
           if (i == 1252 || y > 395 || y < 64) {
                break;
            }
            //Hvis der er mere end en måling tegnes streger.
            if (i > 0 && grafData.length > 1) {
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(gx, gy, x, y);
            }
            gx = x;
            gy = y;

            x += 1;


            
           
        }

    }
}
