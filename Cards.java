/**
 * Class containing all procedures from SQL converted into working Java methods
 *
 * @author (Namson Nguyen and Giovanni Casiano)
 * @version (Version 1, Nov.20.2022)
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
public class Cards
{
    /**
     * Seaches for any card given a name and outputs the card's stats
     * 
     * @param Name - The card to be searched
     */
    public static void printCardStatsByName(String Name) {
        Champions.printStatsByName(Name);
        Units.printStatsByName(Name);
        Abilities.printStatsByName(Name);
        Landmarks.printStatsByName(Name);
        Traps.printStatsByName(Name);
        Spells.printStatsByName(Name);
    }
    
    /**
     * Searches for any cards that belong in the given region
     * 
     * @param Region - The region that will be searched
     */
    public static void printListByRegion(String Region) {
        Champions.printListByRegion(Region);
        Units.printListByRegion(Region);
        Abilities.printListByRegion(Region);
        Landmarks.printListByRegion(Region);
        Traps.printListByRegion(Region);
        Spells.printListByRegion(Region);
    }
    
    /**
     * Searches only champions and units that belong in the given region
     * 
     * @param Region - The region that will be searched
     */
    public static void printListAllUnitsByRegion(String Region) { 
        Champions.printListByRegion(Region);
        Units.printListByRegion(Region);
    }
    
    /**
     * Searches for any cards whose artwork was made by the given artist
     * 
     * @param Artist - the artist that will be searched
     */
    public static void printListByArtist(String Artist) {
        Champions.printListByArtist(Artist);
        Units.printListByArtist(Artist);
        Abilities.printListByArtist(Artist);
        Landmarks.printListByArtist(Artist);
        Traps.printListByArtist(Artist);
        Spells.printListByArtist(Artist);
    }
    
    /**
     * Searches for any cards that has the given rarity
     * 
     * @param Rarity - the rarity that will be searched
     */
    public static void printListByRarity(String Rarity){
        Champions.printListByRarity(Rarity);
        Units.printListByRarity(Rarity);
        Abilities.printListByRarity(Rarity);
        Landmarks.printListByRarity(Rarity);
        Traps.printListByRarity(Rarity);
        Spells.printListByRarity(Rarity);
    }
}

