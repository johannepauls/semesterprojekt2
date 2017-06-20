package semesterprojekt2ekg;

import java.util.*;
import jssc.*;

public class Sensor extends Thread {

    private String port;
    private String inputsub;
    private boolean conn;
    private Queue ko;
    private DataBehandler data;
    private String rest = "";
    private String result;
    private SerialPort serialPort;
    private int[] tab = new int[250];
    private int[] filt;
    private int t;

    /*
    Konstruktøren Sensor() undersøger om der er en serial port tilsluttet.
    Undersøger hvor mange porte, der er tilsluttet. Hvis der er mere end en 
    tilsluttet, gives der en mulighed for at vælge. Til sidst åbnes forbindelsen
    til porten.
     */
    Sensor(Queue q, DataBehandler d) {
        ko = q;
        data = d;
        int p = 1;
        // Finder serielport.
        String[] portNames = SerialPortList.getPortNames();

        if (portNames.length == 1) {
            String input = Arrays.toString(portNames);
            inputsub = input.substring(1, input.length() - 1);
            port = inputsub;
        } else if (portNames.length > 1) {
            System.out.println("Du har flere serielle porte. Der vises herunder:");
            for (String portName : portNames) {
                System.out.println(p + ": " + portName);
                p++;
            }
            System.out.println("Vælg nu den serielle port du ønsker at anvende.");
            System.out.println("Dette gøres ved at indtaste indexnummeret for porten efterfulgt af Enter.");
            Scanner scan = new Scanner(System.in);
            int index = Integer.parseInt(scan.nextLine());

            String input = portNames[index - 1];
            //inputsub = input.substring(1, input.length()-1);
            port = input;
        }

        //vi åbner porten hvorfra vi skal få vores data:
        serialPort = new SerialPort(port);
        conn = true;

        try {
            serialPort.openPort();//Open serial port
            serialPort.setParams(19200, 8, 1, 0);//Set params.
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            serialPort.readString();
        } catch (Exception ex) {
            System.out.println("Ingen sensor tilsluttet");
        }

        /*vi henter en måling ind for at klippe den sidste bid af fra skilletegnet
        *og sætter det på den første reelle måling*/
    }

    public void run() {
        try {
            while (serialPort.getInputBufferBytesCount() <= 0) {
                sleep(100);

            }
            result = serialPort.readString();
        } catch (Exception ex) {
            System.out.println("Exception i Sensor: " + ex);
        }
        int last = result.lastIndexOf(",");
        if (last > -1 && last < result.length() - 1) {
            rest = result.substring(last + 1);
        }

        while (conn == true) {

            //return type ændres til hvad end vi gemmer data som 
            try {
                //vi starter læsning fra porten
                if (serialPort.getInputBufferBytesCount() > 0) {
                    //da vi får bidder af en lang streng indeholdende vores målinger,
                    //kan vi ikke være sikker på at den nuværende bid indeholder
                    //korrekte tal i enderne. Vi risikere at et tal bliver delt over
                    //i enden af en bid, og dermed fortsætter i starten på næste bid.
                    //Derfor tilføjer vi vores rest fra sidste string i starten af den
                    //nuværende string.

                    result = rest + serialPort.readString();
                    //System.out.println(result);
                    
                    
                    //vi definere den sidste værdi i vores string for senere at kunne
                    //tjekke hvad vores rest er.
                    String check = result.substring(result.length() - 1);
                    //vores data fra arduinoen er delt med et "," så derfor deler vi
                    //strengen ved alle ",":

                    String[] delttest = result.split(",");

                    //i tilfælde af at vi ikke har nogen rest, og vores string
                    //er delt ved et komma, definere vi vores rest som ingenting.
                    //ellers definere vi vores rest som sidste værdi i arrayet
                    if (check.equals(",")) {
                        rest = "";
                    } else {
                        rest = delttest[delttest.length - 1];
                    }
                    if (result.length() > 1) {
                        result = result.substring(0, result.lastIndexOf(","));
                    }
                    //vi sletter en eventuel rest fra den nuværende streng, da den bliver
                    //tilføjet til starten af næste streng. Vi kører løkken 4 gange, da
                    //det er maks antal værdier det kan blive nødvendigt at slette
                    //eksempel: ...,1023   (delt)     ,1010... (vi vil have slettet
                    //1023 da det er en rest der bliver tilføjet til næste streng)
                    /* if (result.length() > 1) {
                        for (int i = 0; i < 4; i++) {
                            if (!result.substring(result.length() - 1).equals(",")) {
                                //hvis IKKE det sidste bogstav i resultatet er ,
                                //hvad skal der ske?
                                //så er resultatet = result - 1 tegn.
                                result = result.substring(0, result.length() - 1);
                            }
                        }
                    }*/
                    //vi ændrer nu vores string array til et int array

                    String[] deltrettet = result.split(",");

                    int[] intarray = new int[deltrettet.length];
                    filt = new int[intarray.length];
                    int value;
                    for (int i = 0; i < intarray.length; i++) {
                        intarray[i] = -1;
                        try {
                            intarray[i] = Integer.parseInt(deltrettet[i]);
                            if (intarray[i] > 1023) {
                                intarray[i] = -1;
                            }
                        } catch (NumberFormatException ex) {
                            intarray[i] = -1;
                        }
                        if (intarray[i] == -1) {
                            if (i > 0) {
                                intarray[i] = intarray[i - 1];
                            } else {
                                intarray[i] = 0;
                            }
                        }

                        int filtValue = (int) (data.filter(intarray[i]));
                        //System.out.println(intarray[i]);
                        filt[i] = filtValue;
                    }

                    for (int i = 0; i < filt.length; i++) {

                        if (t >= 250) {
                            ko.addToQueue(tab);
                            tab = new int[250];
                            t = 0;

                        } else {
                            tab[t] = filt[i];
                            t++;
                            
                        }
                    }

                    sleep(100);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
