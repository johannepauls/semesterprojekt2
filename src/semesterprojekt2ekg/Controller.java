package semesterprojekt2ekg;

import javax.swing.*;

public class Controller {
    //opret objekter

    public static void main(String[] args) {
        Queue q = new Queue();
        SensorTest kom = new SensorTest(q);
        Thread k = new Thread(kom);
        Arkiv database = new Arkiv(q);
        Thread a = new Thread(database);
        DataBehandler data = new DataBehandler(database);
        Thread d = new Thread(data);

        //final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // JFrame objekt oprettes.
        JFrame ramme = new JFrame();
        // JFrame objekt tilføjer Gui.
        ramme.add(new Gui());
        // Set en titel på rammen
        ramme.setTitle("EKG");
        // Gør at programmet lukkes, når der klikkes på den røde knap
        ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Vindue er maksimeret når programmet køres.
        ramme.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //ramme.setSize(screenSize);
        //ramme.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        // Brugeren får ikke mulighed for at ændre på vinduets størrelse
        ramme.setResizable(true);
        // Gør at vinduet fylder mindst muligt
        ramme.pack();
        // Visning af rammen med hovedklassen inden i
        ramme.setVisible(true);

        k.start();
        a.start();
        d.start();
        //data.dataSamler();
    }

}
