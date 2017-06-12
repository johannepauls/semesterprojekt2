package semesterprojekt2ekg;

import javax.swing.*;

public class Controller {

    //opret objekter
    // JFrame objekt oprettes.
    private static JFrame ramme = new JFrame();
    private static Queue q = new Queue();
    private static SensorTest kom = new SensorTest(q);
    private static Thread sensorThread = new Thread(kom);
    private static Arkiv database = new Arkiv(q);
    private static Thread arkivThread = new Thread(database);
    private static DataBehandler data = new DataBehandler(database);
    private static Graf graf = new Graf(database);
    private static Gui panel = new Gui(graf);

    public static void main(String[] args) {

        //final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // JFrame objekt tilføjer Gui.
        ramme.add(panel);
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

        sensorThread.start();
        arkivThread.start();
        //data.dataSamler();
        
        try { 
            /*programmet vil pga. uendelig løkke køre til vi lukker det*/
            while (true) {
                /*programmet tester hvorvidt vi har trykket på start*/
                if (panel.getStart()) {
                    /*vi henter en pulsværdi, der beregnes af databehandleren. Denne puls 'skrives' på GUI'en*/
                    double puls = data.getPuls();
                    panel.setPuls(puls);
                    //System.out.println("virker det?");

                }
                /*tråden sover et sekund, ellers skabes problemer med at getStart() ikke virker*/
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println("undtagelse: " + e.getMessage());					
            e.printStackTrace();
        }
    }

}
