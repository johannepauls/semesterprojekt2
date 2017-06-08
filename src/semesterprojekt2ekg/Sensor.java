package semesterprojekt2ekg;

import java.util.Arrays;
import jssc.SerialPort;
import jssc.SerialPortException;
import java.util.Scanner;
import jssc.SerialPortList;

public class Sensor {
    String rest = "";
    SerialPort serialPort ;
    int[] intarray;
    String port;
    String inputsub;
    
    
    Sensor() {
        int p = 1;
        // Finder serielport.
        String[] portNames = SerialPortList.getPortNames();
        
        if(portNames.length == 1){
        String input = Arrays.toString(portNames);
        inputsub = input.substring(1, input.length()-1);
        port = inputsub;
        }else if(portNames.length > 1){
            System.out.println("Du har flere serielle porte. Der vises herunder:");
          for (String portName : portNames) {
            System.out.println(p + ": " + portName);
            p++;
        } 
            System.out.println("Vælg nu den serielle port du ønsker at anvende.");
            System.out.println("Dette gøres ved at indtaste indexnummeret for porten efterfulgt af Enter.");
            Scanner scan = new Scanner(System.in);
            int index = Integer.parseInt(scan.nextLine());
            
            String input = portNames[index-1];
            inputsub = input.substring(1, input.length()-1);
            port = inputsub;
        }
        
        
        
        //vi åbner porten hvorfra vi skal få vores data:
        serialPort = new SerialPort(port);
        try {
            serialPort.openPort();//Open serial port
            serialPort.setParams(9600, 8, 1, 0);//Set params.
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            serialPort.setDTR(true);
        } catch (SerialPortException spe) {
            System.out.println("Ingen sensor tilsluttet");
        }
    }
    
    
    
    public void setData(){
        //hent data fra arduino

       
    }
        
    
    
    public int[] getData(){
       
        
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
               
                String result = rest + serialPort.readString();
                System.out.println("0  : " + result);
                //vi definere den sidste værdi i vores string for senere at kunne
                //tjekke hvad vores rest er.
                String check = result.substring(result.length() - 1);
                //vores data fra arduinoen er delt med et "," så derfor deler vi
                //strengen ved alle ",":
               
                String[] delttest = result.split(",");

                //i tilfælde af at vi ikke har nogen rest, og vores strint
                //er delt ved et komma, definere vi vores rest som ingenting.
                //ellers definere vi vores rest som sidste værdi i arrayet
                if (check.equals(",")) {                         
                    rest = "";
                } else {  
                    rest = delttest[delttest.length - 1];
                }
                
                //vi sletter en eventuel rest fra den nuværende streng, da den bliver
                //tilføjet til starten af næste streng. Vi kører løkken 4 gange, da
                //det er maks antal værdier det kan blive nødvendigt at slette
                //eksempel: ...,1023   (delt)     ,1010... (vi vil have slettet
                //1023 da det er en rest der bliver tilføjet til næste streng)
                for (int i = 0; i < 4; i++) {
                    if (!result.substring(result.length() - 1).equals(",")) {  
                        //hvis IKKE det sidste bogstav i resultatet er ,
                        //hvad skal der ske?
                        //så er resultatet = result - 1 tegn.
                        result = result.substring(0, result.length() - 1);
                    }
                }
                
                //vi ændrer nu vores string array til et int array
                String[] deltrettet = result.split(",");
                intarray = new int[deltrettet.length];
                
                for (int i = 0; i < deltrettet.length; i++) {

                    intarray[i] = Integer.parseInt(deltrettet[i]);
                    
                }
                System.out.println("1  : " + Arrays.toString(intarray));
            }
        } catch (SerialPortException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        
        return intarray;
    }
    
    
}