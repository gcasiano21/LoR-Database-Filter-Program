/**
 * Contains the methods to create unit card objects and manipulate them
 *
 * @author (Namson Nguyen & Giovanni Casiano)
 * @version (Version 1 Nov.24.2022)
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class Units
{
    private String name;
    private String effect;
    private String keyword1;
    private String keyword2;
    private String keyword3;
    private int attack;
    int health;
    int cost;
    int playNum;     //To differentiate between card copies and determine order
    
    /**
     * Creates a unit card object
     * Used to create an ambiguous unit card object
     * 
     */
    public Units(){
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
     * Returns the health of a card object
     * 
     * @return - The health of a card object
     */
    public int getHealth(){
        return this.health;
    }
    
    /**
     * Sets the health of a card object to the desired number
     * 
     * @param num - The number to which the card object's health is set
     */
    public void setHealth(int num){
         this.health = num;
    }
    
    /**
     * Returns the attack of a card object
     * 
     * @return - The attack of a card object
     */
    public int getAttack(){
        return this.attack;
    }
    
    /**
     * Returns the name of a card object
     * 
     * @return - The name of a card object
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Completes a unit card object, filling in the remaining attributes given the unit name and playNum
     * 
     * @param cardName - The name of the unit whose stats will be entered into the card object
     * @param playNum - The playNum of the object
     */
    public void playCard(String cardName, int playNum){
        
        String query = "{ call getUnitByName(?) }";
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
                this.attack = rs.getInt("attack");
                this.health = rs.getInt("health");
                this.cost = rs.getInt("cost");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Returns the stats of a unit card object in a formatted manner
     * 
     * @return - The stats of the unit card object
     */
    public String toString(){
        this.name = name;
        this.effect = effect;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.attack = attack;
        this.health = health;
        this.cost = cost;
        
        String s = "Unit: " + this.name + "\n" +
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
        
        String s3 = "Attack: " + this.attack + "\n" +
                    "Health: " + this.health + "\n" +
                    "Cost: " + this.cost + "\n";
                
        return  s + s2 + s3 + "\n";
                
    }
    
    public static void printStatsByName(String Name) {
        String query = "{ call getUnitByName(?) }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Name);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                System.out.print("Unit: " + rs.getString("card_name") + "\n" + 
                                    "Region(s): " + rs.getString("region_1")
                                    );
                                        if(rs.getString("region_2") == "") { 
                                            System.out.print("\n");
                                        }
                                        else {
                                            System.out.print(", " + rs.getString("region_2") + "\n");
                                        }
                System.out.println("Attack: " + rs.getInt("attack") + "\n" +
                                    "Health: " + rs.getInt("health") + "\n" +
                                    "Cost: " + rs.getInt("cost") + "\n" +
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
        String query = "{ call getUnitsByRegion(?) }";

        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Region);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                System.out.println("Unit: " + rs.getString("card_name") + "\n" + 
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
        
        String query = "{ call getUnitsByRarity(?) }";
        
        ResultSet rs;
        
        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Rarity);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                System.out.println("Unit: " + rs.getString("card_name") + "\n" + 
                                    "Rarity: " + rs.getString("rarity") + "\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void printListByArtist(String Artist) {
        
        String query = "{ call getUnitsByArtistName(?) }";
        
        ResultSet rs;
        
        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Artist);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                System.out.println("Unit: " + rs.getString("card_name") + "\n" + 
                                    "Artist Name: " + rs.getString("artist_name") + "\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
       
    
    public static int getAttackByName(String Name) { 
        String query = "{ call getAttackByName(?) }";
        ResultSet rs;

        try (Connection conn = MySQLJDBCUtil.getConnection(); //Create a connection
                CallableStatement stmt = conn.prepareCall(query)){ // Define statement

            stmt.setString(1, Name);

            rs = stmt.executeQuery(); // Execute Statement
            while (rs.next()) {
                return rs.getInt("attack");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }
        return -1;
    }
}
