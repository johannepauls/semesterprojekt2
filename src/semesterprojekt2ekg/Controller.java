package semesterprojekt2ekg;

import javax.swing.*;


public class Controller {
    //opret objekter

    public static void main(String[] args) {

        Sensor kom = new Sensor();
        Thread k = new Thread(kom);
        DataBehandler data = new DataBehandler();

        k.start();
        data.setData(kom.getData());
        data.dataSamler();

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

    }

}
