package semesterprojekt2ekg;

import java.sql.*;

public class Arkiv implements Runnable {

    private Queue ko;
    private String value;
    private Connection conn;
    private Statement stmt;
    private PreparedStatement stmt2;
    private ResultSet rset;
    private String result;
    private int[] intarray;

    /*Konstruktør der opretter forbindelse til sqlite serveren og opretter en tabel
    * som vi gør klar til at sætte ind i*/
    public Arkiv(Queue q) {
        ko = q;
        try {
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:MyDB.db");

            stmt = conn.createStatement();

            /*Vi tjekker hvorvidt tabellen 'maaling' findes i databasen
            *hvis tabellen ikke findes opretter vi en tabel
            *tabellen består af: 
            *et id, der er primær nøgle og indstilles automatisk; 
            *en værdi, der består af en lang string;
            *en tidsangivelse, der indstilles automatisk*/
            try {
                ResultSet test = stmt.executeQuery("SELECT * FROM maaling");
            } catch (Exception e) {
                stmt.executeUpdate("CREATE TABLE maaling(id Integer PRIMARY KEY AUTOINCREMENT, value VARCHAR(2500), tid TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL)");
            }
            stmt2 = conn.prepareStatement("INSERT INTO maaling (value) VALUES (?)");
           
        } catch (Exception e) {
            System.out.println("jtest undtagelse: " + e.getMessage());
            e.printStackTrace();
        }

    }
    
    
    @Override
    public void run() {
        for (;;) {
            /*Hvis der er elementer i køen, gemmer vi strengen i databasen*/
            if (!ko.isQueueArray()) {
                value = ko.processQueue();
                try {
                    stmt2.setString(1, value);
                    stmt2.executeUpdate();

                } catch (Exception e) {
                    System.out.println("jtest undtagelse: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized int[] Download() {
        /*vi henter den nederste række i databasen og konventer strengen til et array af int værdier*/
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
            System.out.println("jtest undtagelse: " + e.getMessage());
            e.printStackTrace();
        }
        return intarray;
    }
}
