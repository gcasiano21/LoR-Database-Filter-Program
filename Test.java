/**
 * Testing class
 *
 * @author (Namson Nguyen & Giovanni Casiano)
 * @version (Version 1 Nov.26.2022)
 */
public class Test
{
    public static void main(String[] args){
        String champName = "Lissandra";
        Champions card1 = new Champions();
        card1.playCard(champName, 1);
        System.out.println(card1.toString());
        
        String unitName = "Nimble Poro";
        Units card2 = new Units();
        card2.playCard(unitName, 2);
        System.out.println(card2.toString());
        
        String abilityName = "Sabotage";
        Abilities card3 = new Abilities();
        card3.playCard(abilityName, 3);
        System.out.println(card3.toString());
        
        String landmarkName = "Star Spring";
        Landmarks card4 = new Landmarks();
        card4.playCard(landmarkName, 4);
        System.out.println(card4.toString());
        
        String trapName = "Poison Puffcap";
        Traps card5 = new Traps();
        card5.playCard(trapName, 5);
        System.out.println(card5.toString());
        
        String spellName = "Final Spark";
        Spells card6 = new Spells();
        card6.playCard(spellName, 6);
        System.out.println(card6.toString());
    }
}
