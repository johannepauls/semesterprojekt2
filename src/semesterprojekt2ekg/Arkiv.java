package semesterprojekt2ekg;

import java.sql.*;
import java.util.*;

public class Arkiv extends Thread {

    private Queue ko;
    private int[] value;
    private Connection conn;
    private Statement stmt;
    private String s;
    private ResultSet rset;
    private int result;
    private ArrayList<Integer> intArray = new ArrayList<Integer>();
    private int last;
    private int[] download= null;
    private int count = 0;

    /*Konstruktør der opretter forbindelse til sqlite serveren og opretter en tabel
    * som vi gør klar til at sætte ind i*/
    public Arkiv(Queue q) {
        ko = q;
        try {
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:semesterprojekt2.db");

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
                stmt.executeUpdate("CREATE TABLE maaling(id Integer PRIMARY KEY AUTOINCREMENT, value INT, tid TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL)");
            }

        } catch (Exception e) {
            System.out.println("jtest undtagelse: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        s = null;
        for (;;) {
            value = ko.processQueue();
            
            s = "INSERT INTO maaling (value) VALUES ";
            for (int i = 0; i < 250; i++) {
                if(i>0) s+=",";
                
                s+="("+value[i]+") ";
            }
            update(s);
        }
    }

    private synchronized void update(String s) {
        try {
            stmt.executeUpdate(s);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public synchronized int[] Download() {
        /*vi henter den nederste række i databasen og konventer strengen til et array af int værdier*/
        try {
            rset = stmt.executeQuery("SELECT * FROM maaling ORDER BY id DESC LIMIT 1250");
            
            if(count<1250){
                rset =stmt.executeQuery("SELECT count(*) FROM maaling");
                if(rset.next()){
                    count = rset.getInt(1);
                }
                return null;
            }
            
            last = 1250;
            download = new int[last];
            for(last--; last>-1; last--){
                rset.next();
                download[last]=rset.getInt(2);
            }
            //System.out.println(""+Arrays.toString(download));
        } catch (Exception e) {
            System.out.println("jtest undtagelse: " + e.getMessage());
            e.printStackTrace();
        }
        
        return download;
    }
}
