package semesterprojekt2ekg;

import javax.swing.JFrame;

public class Controller {
    //opret objekter
    
    public static void main(String[] args) {
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
        // Brugeren får ikke mulighed for at ændre på vinduets størrelse
        ramme.setResizable(false);
        // Gør at vinduet fylder mindst muligt
        ramme.pack();
        // Visning af rammen med hovedklassen inden i
        ramme.setVisible(true);
    }
    
}
