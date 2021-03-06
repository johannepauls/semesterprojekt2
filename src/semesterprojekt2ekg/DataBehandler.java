package semesterprojekt2ekg;

import java.util.*;

public class DataBehandler {

    private Arkiv db;
    private static Timer timer = new Timer(true);
    private double filtValue;
    private int[] filtData;
    private int startTime = -1;
    private int endTime;
    private int diffTime;
    private ArrayList<Double> unFilt = new ArrayList<Double>();
    private int n = 0;
    private int puls = 0;
    private int a;
    private int k;

    DataBehandler(Arkiv database) {
        db = database;
    }

    public void setPuls() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                int[] data = db.Download();
                if (data != null) {
                    filtData = data;
                }

                for (int i = 3; i < filtData.length; i++) {
                    if (filtData[i] <= filtData[i - 1] && filtData[i - 2] > filtData[i - 3] && filtData[i] >= 300) {
                        endTime = i;

                        diffTime = (endTime - startTime) * 4;
                        if (diffTime >= (40 * 4) && startTime != -1) {
                            puls = Math.round(60000 / diffTime);
                            //System.out.println("start: " + startTime + " stop: " + endTime + " puls: " + puls);
                        }

                        startTime = endTime;
                    }
                }
            }

        }, 0, 1000);

    }

    public int getPuls() {
        /*giver muligvis fejl - sikring af timer og puls*/
        //returner den beregnet puls værdi
        return puls;
    }

    public double filter(int unFiltInt) {

        //Implementation af filterkoefficienter.
        double[] coeff = {0.000192642670559929, -0.000295969341969912, -0.0159646050723928, -0.00141767205494229, 0.00495873534467181, 0.00492932912433127, -0.00143829785398881, -0.00412229652150344, -0.000725583496722631, 0.00118222316646138, -0.000493620065620664, 0.00117486041703018, 0.00596748357539415, 0.00280771876672282, -0.00887378244319598, -0.0109860974401662, 0.00516533462288644, 0.0183028286541792, 0.00622757120682425, -0.0162677482910494, -0.0162498459104114, 0.00615499706861166, 0.0175965568532649, 0.00462707138156552, -0.00813217121457955, -0.00387900351447397, -0.000240686581763361, -0.00855394505719800, -0.00509685654838130, 0.0213134779323662, 0.0291943825744723, -0.0140579514651684, -0.0562947380890519, -0.0204999499794175, 0.0624818572848815, 0.0703033812156306, -0.0293789880659520, -0.103472656048910, -0.0339767809951856, 0.0940287556341654, 0.0973049963592231, -0.0376970246354199, 0.876791146211192, -0.0376970246354199, 0.0973049963592231, 0.0940287556341654, -0.0339767809951856, -0.103472656048910, -0.0293789880659520, 0.0703033812156306, 0.0624818572848815, -0.0204999499794175, -0.0562947380890519, -0.0140579514651684, 0.0291943825744723, 0.0213134779323662, -0.00509685654838130, -0.00855394505719800, -0.000240686581763361, -0.00387900351447397, -0.00813217121457955, 0.00462707138156552, 0.0175965568532649, 0.00615499706861166, -0.0162498459104114, -0.0162677482910494, 0.00622757120682425, 0.0183028286541792, 0.00516533462288644, -0.0109860974401662, -0.00887378244319598, 0.00280771876672282, 0.00596748357539415, 0.00117486041703018, -0.000493620065620664, 0.00118222316646138, -0.000725583496722631, -0.00412229652150344, -0.00143829785398881, 0.00492932912433127, 0.00495873534467181, -0.00141767205494229, -0.0159646050723928, -0.000295969341969912, 0.000192642670559929};

        //Konvertering af int-arraylist til double-arraylist.
        double unFiltDouble = (double) (unFiltInt);
        //System.out.print(unFiltInt+" ");
        unFilt.add(0, unFiltDouble);

        //Foldning af data og filterkoefficienter.
        //i det her tilfælde y(n) = ...h(k) * x(h-k)
        filtValue = 0;

        if (unFilt.size() < 85) {
            a = unFilt.size() - 1;
        } else {
            a = 84;
        }
        for (k = 0; k < coeff.length; k++) {

            filtValue = ((filtValue + (coeff[k] * unFilt.get(a)))/1.5)+30;
            if (a > 0) {
                a--;
            } else {
                a = 0;
            }
        }

        n++;
        k = 0;

        //Return
        return filtValue;

    }
}
