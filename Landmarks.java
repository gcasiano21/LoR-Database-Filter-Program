/**
 * Contains the methods to create landmark card objects and manipulate them
 *
 * @author (Namson Nguyen & Giovanni Casiano)
 * @version (Version 1 Nov.24.2022)
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class Landmarks
{
    private String name;
    private String effect;
    private String keyword1;
    private String keyword2;
    private String keyword3;
    private int cost;
    private int playNum;     //To differentiate between card copies and determine order
    
    /**
     * Creates a landmark card object
     * Used to create an ambiguous landmark card object
     * 
     */
    public Landmarks(){
    }
    
    /**
     * Returns the playNum of a card object
     * 
     * @return - The playNum of a card object
     */
    public int getPlayNum(){
        return this.playNum;
    }
    
    /**
     * Completes a landmark card object, filling in the remaining attributes given the landmark name and playNum
     * 
     * @param cardName - The name of the landmark whose stats will be entered into the card object
     * @param playNum - The playNum of the object
     */
    public void playCard(String cardName, int playNum){
        
        String query = "{ call getLandmarkByName(?) }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, cardName);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                this.name = rs.getString("card_name");
                this.effect = rs.getString("effect");
                this.keyword1 = rs.getString("keyword_1");
                this.keyword2 = rs.getString("keyword_2");
                this.keyword3 = rs.getString("keyword_3");
                this.cost = rs.getInt("cost");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Returns the stats of a landmark card object in a formatted manner
     * 
     * @return - The stats of the landmark card object
     */
    public String toString(){
        this.name = name;
        this.effect = effect;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.cost = cost;
        
        String s = "Landmark: " + this.name + "\n" +
                "Effect: " + this.effect + "\n" +
                "Keyword(s): " + this.keyword1;
                
        String s2 = "\n";
        
        if(this.keyword2 == "") {
                    s2 = "\n";
                }
                else if(this.keyword3 == ""){
                    s2 = ", " + this.keyword2 + "\n";
                }
                else {
                    s2 = ", " + this.keyword2 + ", " + this.keyword3 + "\n";
                }
        
        String s3 = "Cost: " + this.cost + "\n";
                
        return  s + s2 + s3 + "\n";
                
    }
    
    public static void printStatsByName(String Name) {
        String query = "{ call getLandmarkByName(?) }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Name);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                System.out.print("Landmark: " + rs.getString("card_name") + "\n" + 
                                    "Region(s): " + rs.getString("region_1")
                                    );
                                        if(rs.getString("region_2") == "") { 
                                            System.out.print("\n");
                                        }
                                        else {
                                            System.out.print(", " + rs.getString("region_2") + "\n");
                                        }
                System.out.println("Cost: " + rs.getInt("cost") + "\n" +
                                    "Effect: " + rs.getString("effect") + "\n" +
                                    "Keyword(s): " + rs.getString("keyword_1"));
                                        if(rs.getString("keyword_2") == "") {
                                            System.out.print("\n");
                                        }
                                        else if(rs.getString("keyword_3") == ""){
                                            System.out.print(", " + rs.getString("keyword_2") + "\n");
                                        }
                                        else {
                                            System.out.print(", " + rs.getString("keyword_2") + ", " + rs.getString("keyword_3") + "\n");
                                        }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void printListByRegion(String Region) {
        String query = "{ call getLandmarksByRegion(?) }";

        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Region);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                System.out.println("Landmark: " + rs.getString("card_name") + "\n" + 
                                    "Region(s): " + rs.getString("region_1")
                                    );
                                        if(rs.getString("region_2") == "") { 
                                            System.out.print("\n");
                                        }
                                        else {
                                            System.out.println(", " + rs.getString("region_2") + "\n");
                                        }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void printListByRarity(String Rarity) {
        
        String query = "{ call getLandmarksByRarity(?) }";
        
        ResultSet rs;
        
        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Rarity);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                System.out.println("Landmark: " + rs.getString("card_name") + "\n" + 
                                    "Rarity: " + rs.getString("rarity") + "\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void printListByArtist(String Artist) {
        
        String query = "{ call getLandmarksByArtistName(?) }";
        
        ResultSet rs;
        
        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Artist);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                System.out.println("Landmark: " + rs.getString("card_name") + "\n" + 
                                    "Artist Name: " + rs.getString("artist_name") + "\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
