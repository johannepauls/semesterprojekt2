package semesterprojekt2ekg;

import java.sql.*;
import java.util.ArrayList;

public class Arkiv implements Runnable {

    private Queue ko;
    private String value;
    private Connection conn;
    private Statement stmt;
    private PreparedStatement stmt2;
    private ResultSet rset;

    private String result;
    private int[] intarray;

    public Arkiv(Queue q) {
        ko = q;
        try {
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:MyDB.db");

            stmt = conn.createStatement();

            try {
                ResultSet test = stmt.executeQuery("SELECT * FROM maaling");
            } catch (Exception e) {
                stmt.executeUpdate("CREATE TABLE maaling(id Integer PRIMARY KEY AUTOINCREMENT, value VARCHAR(2500), tid TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL)");
            }
            stmt2 = conn.prepareStatement("INSERT INTO maaling (value) VALUES (?)");
            System.out.print("det virker!");

        } catch (Exception e) {
            System.out.println("jtest undtagelse: " + e.getMessage());					// udskriv fejlmeddelelse
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        for (;;) {
            if (!ko.isQueueArray()) {
                value = ko.processQueue();
                try {
                    stmt2.setString(1, value);											// klargoer indsaettelse
                    stmt2.executeUpdate();

                } catch (Exception e) {
                    System.out.println("jtest undtagelse: " + e.getMessage());					// udskriv fejlmeddelelse
                    e.printStackTrace();
                }
            }
        }
    }

    public int[] Download() {
        //data.clear();
        try {
            rset = stmt.executeQuery("SELECT * FROM maaling ORDER BY id DESC LIMIT 1");
            while (rset.next()) {
                result = rset.getString(2);

                String[] deltrettet = result.split(",");
                intarray = new int[deltrettet.length];

                for (int i = 0; i < deltrettet.length; i++) {

                    intarray[i] = Integer.parseInt(deltrettet[i]);  //***OBS: NumberFormatException nogle gange!!!***
                }               
            }
        } catch (Exception e) {
            System.out.println("jtest undtagelse: " + e.getMessage());					// udskriv fejlmeddelelse
            e.printStackTrace();
        }
        /*TEST value - rigtigt: data*/
        return intarray;
    }
}
