/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterprojekt2ekg;


import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class Test {
        private Queue ko;
    private static int[] value;
    private static Connection conn;
    private static Statement stmt;
    private static String s;
    private static ResultSet rset;
    private static int result;
    private static ArrayList<Integer> intArray = new ArrayList<Integer>();
    private static int last;
    private static int[] download= null;
    private static int count = 0;
    
    public static void main(String[] args) {
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
            
            rset = stmt.executeQuery("SELECT * FROM maaling ORDER BY id DESC LIMIT 250 ");
            
            while(rset.next()){
                System.out.print(rset.getInt(2)+" ");
            }

        } catch (Exception e) {
            System.out.println("jtest undtagelse: " + e.getMessage());
            e.printStackTrace();
        }
        }
    
}
