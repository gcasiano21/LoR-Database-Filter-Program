/**
 * The User Interface allowing the access of all the primary functions of this program
 *
 * @author (Namson Nguyen and Giovanni Casiano)
 * @version (Version 1 Dec.3.2022)
 */
import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean programRepeat = true; //main program loop
        boolean loop = true; //for inner loops
        boolean invalid = true; //for safety nets
        int selection = -1;
        
        do{
            //Welcome to database
            
            System.out.println("""
                        +--------------------------------------------------------------------------+
                        | Welcome to the Legends of Runeterra Database. What would you like to do? |
                        | Please type one of the corresponding numbers to select your action.      |
                        |--------------------------------------------------------------------------|
                        | 1) Search                                                                |
                        | 2) Simulation                                                            |
                        | 3) I'm done                                                              |
                        +--------------------------------------------------------------------------+""");
            
            //select function (Search, Simulation, Done)

            selection = scan.nextInt(); //chooing search, simulation, or done...
            switch(selection){
                case 1:
                    //Search (specific card, filter)
                    
                    System.out.println("""
                            +---------------------------------------------------------------------+
                            | You have chosen the Search function!                                |
                            | Please type one of the corresponding number to select your action.  |
                            |---------------------------------------------------------------------|
                            | 1) Specific Card                                                    |
                            | 2) Filter                                                           |
                            +---------------------------------------------------------------------+""");
                    
                    selection = scan.nextInt(); //choosing specific card or filter...
                    switch(selection) {
                        case 1:
                            do {
                                //specific card search
                                
                                System.out.println("""
                                    +-------------------------------------------------------------+
                                    | You have chosen to search for a specific card by name       |
                                    |-------------------------------------------------------------|
                                    | Please enter the name of the card you would like to search: |
                                    +-------------------------------------------------------------+
                                    """);
                                
                                scan.nextLine();    
                                String cardName = scan.nextLine();
                                System.out.println("Here are the stats for " + cardName + ": \n");
                                
                                Cards.printCardStatsByName(cardName);
                                
                                System.out.println("""
                                    +------------------------------------------------------+
                                    | Would you like to search for another card?           |
                                    |------------------------------------------------------|
                                    | 1) Yes                                               |
                                    | 2) No                                                |
                                    +------------------------------------------------------+
                                    """);;
                                
                                selection = scan.nextInt();//choosing yes or no to repeat
                                do{
                                    if(selection == 1) {
                                        loop = true;
                                        invalid = false;
                                    }
                                    else if(selection == 2) {
                                        loop = false;
                                        invalid = false;
                                    }
                                    else{
                                        //Error message
                                        System.out.println("Oops! Invalid input\nTry again.");
                                        selection = scan.nextInt();
                                        invalid = true;
                                    }
                                }
                                while(invalid);
                            }
                            while(loop);
                            
                            break;
                            
                        case 2:
                            do {
                                //Filter (region, artist, rarity, class)
                                
                                System.out.println("""
                                    +----------------------------------+
                                    | Please select one of the filters |
                                    |----------------------------------|
                                    | 1) Region                        |
                                    | 2) Artist Name                   |
                                    | 3) Rarity                        |
                                    +----------------------------------+""");
                                
                                selection = scan.nextInt(); //choosing region, artist, rarity, or class...
                                switch(selection) {
                                    case 1:
                                        do{
                                            //filter by region (yes, no)
                                            
                                            System.out.println("""
                                                        +-------------------------------------------------------------+
                                                        | You have chosen to filter your search by region             |
                                                        |-------------------------------------------------------------|
                                                        | Please enter the region you would like to filter:           |
                                                        +-------------------------------------------------------------+
                                                        """);
                                            
                                            scan.nextLine();
                                            String cardRegion = scan.nextLine();
                                            
                                            System.out.println("""
                                                +--------------------------------------------------------+
                                                | Would you like to further filter your search by class? |
                                                |--------------------------------------------------------|
                                                | 1) Yes                                                 |
                                                | 2) No                                                  |
                                                +--------------------------------------------------------+
                                                """);
                                            
                                            selection = scan.nextInt(); //choosing yes or no to enhance filter by class
                                            switch(selection) {
                                                case 1:
                                                    //Filter by region and class
                                                    System.out.println("""
                                                        +---------------------------------------------------------------+
                                                        | You have chosen to enhance your search by class               |
                                                        |---------------------------------------------------------------|
                                                        | Please select one of the classes to filter                    |
                                                        |---------------------------------------------------------------|   
                                                        |   1) Units                                                    |
                                                        |   2) Champions                                                |  
                                                        |   3) Spells                                                   |
                                                        |   4) Abilities                                                |
                                                        |   5) Landmarks                                                |
                                                        +---------------------------------------------------------------+
                                                        """);
                                                        
                                                    selection = scan.nextInt(); //selecting class to filter
                                                    do{
                                                        if(selection == 1 || selection == 2 || selection == 3 || selection == 4 || selection == 5) {
                                                            loop = true;
                                                            invalid = false;
                                                        }
                                                        else{
                                                            //Error message
                                                            System.out.println("Oops! Invalid input\nTry again.");
                                                            selection = scan.nextInt();
                                                            invalid = true;
                                                        }
                                                    }
                                                    while(invalid);
                                                    
                                                    switch(selection) {
                                                        case 1:
                                                            //Units
                                                            System.out.println("All cards with region " +  cardRegion + " and class Units" + " are listed below: ");
                                                            Units.printListByRegion(cardRegion);
                                                            break;
                                                            
                                                        case 2:
                                                            //Champions
                                                            System.out.println("All cards with region " +  cardRegion + " and class Champions" + " are listed below: ");
                                                            Champions.printListByRegion(cardRegion);
                                                            break;
                                                            
                                                        case 3:
                                                            //Spells
                                                            System.out.println("All cards with region " +  cardRegion + " and class Spells" + " are listed below: ");
                                                            Spells.printListByRegion(cardRegion);
                                                            break;
                                                            
                                                        case 4:
                                                            //Abilities
                                                            System.out.println("All cards with region " +  cardRegion + " and class Abilities" + " are listed below: ");
                                                            Abilities.printListByRegion(cardRegion);
                                                            break;
                                                            
                                                        case 5:
                                                            //Landmarks
                                                            System.out.println("All cards with region " +  cardRegion + " and class Landmarks" + " are listed below: ");
                                                            Landmarks.printListByRegion(cardRegion);
                                                            break;
                                                            
                                                        default:
                                                            //Error
                                                            System.out.println("Something went wrong...Please restart the search");
                                                            break;
                                                    }
                                                    
                                                    
                                                    break;
                                                
                                                case 2:
                                                    //Filter by region
                                                    System.out.println("All cards with " +  cardRegion + " are listed below: ");
                                                    Cards.printListByRegion(cardRegion);
                                                    
                                                    break;
                                                
                                                default:
                                                    //Invalid
                                                    System.out.println("Oops! Invalid input");
                                                    
                                                    break;
                                            }
                                            
                                            System.out.println("""
                                                +------------------------------------------------------+
                                                | Would you like to search using another region?       |
                                                |------------------------------------------------------|
                                                | 1) Yes                                               |
                                                | 2) No                                                |
                                                +------------------------------------------------------+
                                                """);;
                                            
                                            selection = scan.nextInt(); //choosing yes or no to repeat
                                            do{
                                                if(selection == 1) {
                                                    loop = true;
                                                    invalid = false;
                                                }
                                                else if(selection == 2) {
                                                    loop = false;
                                                    invalid = false;
                                                }
                                                else{
                                                    //Error message
                                                    System.out.println("Oops! Invalid input\nTry again.");
                                                    selection = scan.nextInt();
                                                    invalid = true;
                                                }
                                            }
                                            while(invalid);
                                        }
                                        while(loop);
                                        break;
                                        
                                    case 2:
                                        do{
                                            //filter by artist (yes, no)
                                            
                                            System.out.println("""
                                                        +-------------------------------------------------------------+
                                                        | You have chosen to filter your search by artist             |
                                                        |-------------------------------------------------------------|
                                                        | Please enter the artist you would like to filter:           |
                                                        +-------------------------------------------------------------+
                                                        """);
                                            
                                            scan.nextLine();
                                            String cardArtist = scan.nextLine();
                                            
                                            System.out.println("""
                                                +--------------------------------------------------------+
                                                | Would you like to further filter your search by class? |
                                                |--------------------------------------------------------|
                                                | 1) Yes                                                 |
                                                | 2) No                                                  |
                                                +--------------------------------------------------------+
                                                """);
                                            
                                            selection = scan.nextInt(); //choosing yes or no to enhance filter by class
                                            switch(selection) {
                                                case 1:
                                                    //Filter by artist and class
                                                    
                                                    System.out.println("""
                                                        +---------------------------------------------------------------+
                                                        | You have chosen to enhance your search by class               |
                                                        |---------------------------------------------------------------|
                                                        | Please select one of the classes to filter                    |
                                                        |---------------------------------------------------------------|   
                                                        |   1) Units                                                    |
                                                        |   2) Champions                                                |  
                                                        |   3) Spells                                                   |
                                                        |   4) Abilities                                                |
                                                        |   5) Landmarks                                                |
                                                        +---------------------------------------------------------------+
                                                        """);
                                                        
                                                    selection = scan.nextInt(); //selecting class to filter
                                                    do{
                                                        if(selection == 1 || selection == 2 || selection == 3 || selection == 4 || selection == 5) {
                                                            loop = true;
                                                            invalid = false;
                                                        }
                                                        else{
                                                            //Error message
                                                            System.out.println("Oops! Invalid input\nTry again.");
                                                            selection = scan.nextInt();
                                                            invalid = true;
                                                        }
                                                    }
                                                    while(invalid);
                                                    
                                                    switch(selection) {
                                                        case 1:
                                                            //Units
                                                            System.out.println("All cards with artist " +  cardArtist + " and class Units" + " are listed below: \n");
                                                            Units.printListByArtist(cardArtist);
                                                            break;
                                                            
                                                        case 2:
                                                            //Champions
                                                            System.out.println("All cards with artist " +  cardArtist + " and class Champions" + " are listed below: \n");
                                                            Champions.printListByArtist(cardArtist);
                                                            break;
                                                            
                                                        case 3:
                                                            //Spells
                                                            System.out.println("All cards with artist " +  cardArtist + " and class Spells" + " are listed below: \n");
                                                            Spells.printListByArtist(cardArtist);
                                                            break;
                                                            
                                                        case 4:
                                                            //Abilities
                                                            System.out.println("All cards with artist " +  cardArtist + " and class Abilities" + " are listed below: \n");
                                                            Abilities.printListByArtist(cardArtist);
                                                            break;
                                                            
                                                        case 5:
                                                            //Landmarks
                                                            System.out.println("All cards with artist " +  cardArtist + " and class Landmarks" + " are listed below: \n");
                                                            Landmarks.printListByArtist(cardArtist);
                                                            break;
                                                            
                                                        default:
                                                            //Error
                                                            System.out.println("Something went wrong...Please restart the search\n");
                                                            break;
                                                    }
                                                    
                                                    break;
                                                    
                                                case 2:
                                                    //Filter by artist
                                                    
                                                    System.out.println("All cards with artist " +  cardArtist + " are listed below: \n");
                                                    Cards.printListByArtist(cardArtist);
                                                    
                                                    break;
                                                
                                                default:
                                                    //Invalid
                                                    System.out.println("Oops! Invalid input");
                                            }
                                            
                                            System.out.println("""
                                                +------------------------------------------------------+
                                                | Would you like to search using another artist?       |
                                                |------------------------------------------------------|
                                                | 1) Yes                                               |
                                                | 2) No                                                |
                                                +------------------------------------------------------+
                                                """);;
                                            
                                            selection = scan.nextInt(); //choosing yes or no to repeat
                                            do{
                                                if(selection == 1) {
                                                    loop = true;
                                                    invalid = false;
                                                }
                                                else if(selection == 2) {
                                                    loop = false;
                                                    invalid = false;
                                                }
                                                else{
                                                    //Error message
                                                    System.out.println("Oops! Invalid input\nTry again.");
                                                    selection = scan.nextInt();
                                                    invalid = true;
                                                }
                                            }
                                            while(invalid);
                                        }
                                        while(loop);
                                        
                                        break;
                                        
                                    case 3:
                                        do{
                                            //filter by rarity (yes, no)
                                            
                                            System.out.println("""
                                                        +-------------------------------------------------------------+
                                                        | You have chosen to filter your search by rarity             |
                                                        |-------------------------------------------------------------|
                                                        | Please enter the rarity you would like to filter:           |
                                                        +-------------------------------------------------------------+
                                                        """);
                                            
                                            scan.nextLine();
                                            String cardRarity = scan.nextLine();
                                            
                                            System.out.println("""
                                                +--------------------------------------------------------+
                                                | Would you like to further filter your search by class? |
                                                |--------------------------------------------------------|
                                                | 1) Yes                                                 |
                                                | 2) No                                                  |
                                                +--------------------------------------------------------+
                                                """);
                                            
                                            selection = scan.nextInt(); //choosing yes or no to enhance filter by class
                                            switch(selection) {
                                                case 1:
                                                    //Filter by rarity and class
                                                    
                                                    System.out.println("""
                                                        +---------------------------------------------------------------+
                                                        | You have chosen to enhance your search by class               |
                                                        |---------------------------------------------------------------|
                                                        | Please select one of the classes to filter                    |
                                                        |---------------------------------------------------------------|   
                                                        |   1) Units                                                    |
                                                        |   2) Champions                                                |  
                                                        |   3) Spells                                                   |
                                                        |   4) Abilities                                                |
                                                        |   5) Landmarks                                                |
                                                        +---------------------------------------------------------------+
                                                        """);
                                                        
                                                    selection = scan.nextInt(); //selecting class to filter
                                                    do{
                                                        if(selection == 1 || selection == 2 || selection == 3 || selection == 4 || selection == 5) {
                                                            loop = true;
                                                            invalid = false;
                                                        }
                                                        else{
                                                            //Error message
                                                            System.out.println("Oops! Invalid input\nTry again.");
                                                            selection = scan.nextInt();
                                                            invalid = true;
                                                        }
                                                    }
                                                    while(invalid);
                                                    
                                                    switch(selection) {
                                                        case 1:
                                                            //Units
                                                            System.out.println("All cards with rarity " +  cardRarity + " and class Units" + " are listed below: \n");
                                                            Units.printListByRarity(cardRarity);
                                                            break;
                                                            
                                                        case 2:
                                                            //Champions
                                                            System.out.println("All cards with rarity " +  cardRarity + " and class Champions" + " are listed below: \n");
                                                            Champions.printListByRarity(cardRarity);
                                                            break;
                                                            
                                                        case 3:
                                                            //Spells
                                                            System.out.println("All cards with rarity " +  cardRarity + " and class Spells" + " are listed below: \n");
                                                            Spells.printListByRarity(cardRarity);
                                                            break;
                                                            
                                                        case 4:
                                                            //Abilities
                                                            System.out.println("All cards with rarity " +  cardRarity + " and class Abilities" + " are listed below: \n");
                                                            Abilities.printListByRarity(cardRarity);
                                                            break;
                                                            
                                                        case 5:
                                                            //Landmarks
                                                            System.out.println("All cards with rarity " +  cardRarity + " and class Landmarks" + " are listed below: \n");
                                                            Landmarks.printListByRarity(cardRarity);
                                                            break;
                                                            
                                                        default:
                                                            //Error
                                                            System.out.println("Something went wrong...Please restart the search\n");
                                                            break;
                                                    }
                                                    
                                                    break;
                                                
                                                case 2:
                                                    //Filter by rarity
                                                    System.out.println("All cards with rarity " +  cardRarity + " are listed below: \n");
                                                    Cards.printListByRarity(cardRarity);
                                                    
                                                    break;
                                                    
                                                default:
                                                    //Invalid
                                                    System.out.println("Oops! Invalid input");
                                                    
                                                    break;
                                            }
                                            
                                            System.out.println("""
                                                +------------------------------------------------------+
                                                | Would you like to search using another rarity?       |
                                                |------------------------------------------------------|
                                                | 1) Yes                                               |
                                                | 2) No                                                |
                                                +------------------------------------------------------+
                                                """);;
                                            
                                            selection = scan.nextInt(); //choosing yes or no to repeat
                                            do{
                                                if(selection == 1) {
                                                    loop = true;
                                                    invalid = false;
                                                }
                                                else if(selection == 2) {
                                                    loop = false;
                                                    invalid = false;
                                                }
                                                else{
                                                    //Error message
                                                    System.out.println("Oops! Invalid input\nTry again.");
                                                    selection = scan.nextInt();
                                                    invalid = true;
                                                }
                                            }
                                            while(invalid);
                                        }
                                        while(loop);
                                        
                                        break;
                                    
                                    default:
                                        //Invalid
                                        System.out.println("Oops! Invalid input");
                                        break;
                                }
                                
                                System.out.println("""
                                                +------------------------------------------------------+
                                                | Would you like to search using another filter?       |
                                                |------------------------------------------------------|
                                                | 1) Yes                                               |
                                                | 2) No                                                |
                                                +------------------------------------------------------+
                                                """);;
                                
                                selection = scan.nextInt();//choosing yes or no to repeat
                                do{
                                    if(selection == 1) {
                                        loop = true;
                                        invalid = false;
                                    }
                                    else if(selection == 2) {
                                        loop = false;
                                        invalid = false;
                                    }
                                    else{
                                        //Error message
                                        System.out.println("Oops! Invalid input\nTry again");
                                        selection = scan.nextInt();
                                        invalid = true;
                                    }
                                }
                                while(invalid);
                            }
                            while(loop);
                            
                            break;
                            
                        default:
                            System.out.println("Oops! Invalid input");
                            break;
                    }
                    
                    break;
                
                case 2:
                    //Simulation (units strike, nexus strike, cast spell, use ability)
                    
                    System.out.println("""
                            +----------------------------------------------------------------------+
                            | You have chosen the Simulation function!                             |
                            | Please type one of the corresponding letters to select your action.  |
                            |----------------------------------------------------------------------|
                            | 1) Have two units strike                                             |
                            | 2) Strike the nexus                                                  |
                            | 3) Cast a spell                                                      |
                            | 4) Use an ability                                                    |
                            +----------------------------------------------------------------------+""");
                    
                    selection = scan.nextInt(); //choosing units strike, nexus strike, cast spell, or use ability...
                    switch(selection) {
                        case 1:
                            do {
                                //units strike
                                
                                System.out.println("""
                                                        +-------------------------------------------------------------+
                                                        | You have selected the units strike simulation               |
                                                        |-------------------------------------------------------------|
                                                        | Please enter name of two units to begin the simulation:     |
                                                        +-------------------------------------------------------------+
                                                        """);
                                
                                do{
                                    scan.nextLine();
                                    System.out.println("Unit 1: ");
                                    String unit1 = scan.nextLine();
                                    
                                    System.out.println("Here are the stats for " + unit1 + ":\n");
                                    Units.printStatsByName(unit1);
                                    
                                    System.out.println("""
                                                        +-------------------------------------------------------------+
                                                        | Is this the unit you are looking for?                       |
                                                        |-------------------------------------------------------------|
                                                        |   1) Yes                                                    |
                                                        |   2) No                                                     |
                                                        +-------------------------------------------------------------+
                                                        """);
                                    selection = scan.nextInt();//choosing yes or no to repeat
                                    do{
                                        if(selection == 1) {
                                            loop = true;
                                            invalid = false;
                                            Units unit1strike = new Units();
                                            unit1strike.playCard(unit1, 1);
                                            
                                            do{
                                                scan.nextLine();
                                                System.out.println("Unit 2: ");
                                                String unit2 = scan.nextLine();
                                                
                                                System.out.println("Here are the stats for " + unit2 + ":\n");
                                                Units.printStatsByName(unit2);
                                                
                                                System.out.println("""
                                                                    +-------------------------------------------------------------+
                                                                    | Is this the unit you are looking for?                       |
                                                                    |-------------------------------------------------------------|
                                                                    |   1) Yes                                                    |
                                                                    |   2) No                                                     |
                                                                    +-------------------------------------------------------------+
                                                                    """);
                                                selection = scan.nextInt();//choosing yes or no to repeat
                                                do{
                                                    if(selection == 1) {
                                                        loop = false;
                                                        invalid = false;
                                                        Units unit2strike = new Units();
                                                        unit2strike.playCard(unit2, 1);
                                                        
                                                        //results
                                                        System.out.println("Round aftermath: " + unit1 + " -->/<-- " + unit2 + "\n");
                                                        
                                                        int unit1health = unit1strike.getHealth();
                                                        int unit2health = unit2strike.getHealth();
                                                        
                                                        unit1strike.setHealth(unit1health - unit2strike.getAttack());
                                                        unit2strike.setHealth(unit2health - unit1strike.getAttack());
                                                        
                                                        System.out.println(unit1 + "\nRemaining Health: " + unit1strike.getHealth() + "\n");
                                                        System.out.println(unit2 + "\nRemaining Health: " + unit2strike.getHealth() + "\n");
                                                        
                                                        if(unit1strike.getHealth() < 0 && unit2strike.getHealth() < 0) {
                                                            System.out.println("Both units have been defeated!\n");
                                                        }
                                                        else if(unit1strike.getHealth() < 0) {
                                                            System.out.println(unit2 + " has defeated " + unit1 + "!\n");
                                                        }
                                                        else if(unit2strike.getHealth() < 0) {
                                                            System.out.println(unit1 + " has defeated " + unit2 + "!\n");
                                                        }
                                                        else{
                                                            System.out.println("Draw! Both units have struck and withdrawn.\n");
                                                        }
                                                        
                                                    }
                                                    else if(selection == 2) {
                                                        loop = true;
                                                        invalid = false;
                                                        System.out.println("Please enter the name of one unit that will be striking.");
                                                    }
                                                    else{
                                                        //Error message
                                                        System.out.println("Oops! Invalid input\nTry again");
                                                        selection = scan.nextInt();
                                                        invalid = true;
                                                    }
                                                }
                                                while(invalid);
                                            }
                                            while(loop);
                                            
                                            
                                        }
                                        else if(selection == 2) {
                                            loop = true;
                                            invalid = false;
                                            System.out.println("Please enter the name of one unit that will be striking.");
                                        }
                                        else{
                                            //Error message
                                            System.out.println("Oops! Invalid input\nTry again");
                                            selection = scan.nextInt();
                                            invalid = true;
                                        }
                                    }
                                    while(invalid);
                                }
                                while(loop);
                                
                                
                                System.out.println("""
                                                +------------------------------------------------------+
                                                | Would you like to simulate another unit strike?      |
                                                |------------------------------------------------------|
                                                | 1) Yes                                               |
                                                | 2) No                                                |
                                                +------------------------------------------------------+
                                                """);;
                                
                                selection = scan.nextInt();//choosing yes or no to repeat
                                do{
                                    if(selection == 1) {
                                        loop = true;
                                        invalid = false;
                                    }
                                    else if(selection == 2) {
                                        loop = false;
                                        invalid = false;
                                    }
                                    else{
                                        //Error message
                                        System.out.println("Oops! Invalid input\nTry again");
                                        selection = scan.nextInt();
                                        invalid = true;
                                    }
                                }
                                while(invalid);
                            }
                            while(loop);
                            
                            break;
                        
                        case 2:
                            
                            
                            do {
                                //nexus strike
                                int totalAttack = 0;
                                int count = 1;
                                int nexus = 20;
                                
                                System.out.println("""
                                                        +-------------------------------------------------------------+
                                                        | You have selected the nexus strike simulation               |
                                                        |-------------------------------------------------------------|
                                                        | Default nexus has 20 health                                 |
                                                        |-------------------------------------------------------------|
                                                        | Try to strike it down in one round!                         |
                                                        |-------------------------------------------------------------|
                                                        | Please enter the name of a unit to begin the simulation:    |
                                                        +-------------------------------------------------------------+
                                                        """);
                                                        
                                Hashtable<Integer, String> units = new Hashtable<>();
                                System.out.println("Unit " + count + ": ");
                                scan.nextLine();
                                String unit = scan.nextLine();
                                units.put(count, unit);
                                
                                System.out.println(unit + " is attacking the nexus for " + Units.getAttackByName(unit) + "\n");
                                
                                System.out.println("""
                                                +--------------------------------------------------------+
                                                | Would you like to add another unit to stike the nexus? |
                                                |--------------------------------------------------------|
                                                | 1) Yes                                                 |
                                                | 2) No                                                  |
                                                +--------------------------------------------------------+
                                                """);;
                                
                                selection = scan.nextInt(); //choosing yes or no to adding more units (up to 5);
                                if(selection == 1) {
                                    do{
                                        //add more units
                                        count ++;
                                        System.out.println("Unit " + count + ": ");
                                        scan.nextLine();
                                        unit = scan.nextLine();
                                        units.put(count, unit);
                                        
                                        System.out.println(unit + " is attacking the nexus for " + Units.getAttackByName(unit) + "\n");
                                        
                                        //ask add more?
                                        System.out.println("You currently have " + count + " units striking the nexus");
                                        System.out.println("""
                                                +--------------------------------------------------------+
                                                | Would you like to add another unit to stike the nexus? |
                                                |--------------------------------------------------------|
                                                | 1) Yes                                                 |
                                                | 2) No                                                  |
                                                +--------------------------------------------------------+
                                                """);;
                                
                                        selection = scan.nextInt();
                                        do{
                                            if(selection == 1 || selection == 2) {
                                                invalid = false;
                                            }
                                            else{
                                                //Error message
                                                System.out.println("Oops! Invalid input\nTry again");
                                                selection = scan.nextInt();
                                                invalid = true;
                                            }
                                        }
                                        while(invalid);
                                        
                                        if(count > 4 && selection == 1){
                                            System.out.println("You can only have a maximum of 5 units striking the nexus at one time!\nStriking nexus with five units...\n");
                                            int num = 1;
                                            for(int i = count; i > 0; i--) {
                                                Units unitStrike = new Units();
                                                unitStrike.playCard(units.get(num), num);
                                                
                                                System.out.println(unitStrike.getName() + " Attack: " + unitStrike.getAttack() + "\n");
                                                
                                                totalAttack += unitStrike.getAttack();
                                                num++;
                                            }
                                        }
                                        else if(selection == 2) {
                                            int num = 1;
                                            for(int i = count; i > 0; i--) {
                                                Units unitStrike = new Units();
                                                unitStrike.playCard(units.get(num), num);
                                                
                                                System.out.println(unitStrike.getName() + " Attack: " + unitStrike.getAttack() + "\n");
                                                
                                                totalAttack += unitStrike.getAttack();
                                                num++;
                                            }
                                        }
                                    }
                                    while(selection == 1 && count < 5);
                                }
                                else if(selection == 2) {
                                    System.out.println("Striking nexus with " + count + " units...");
                                    int num = 1;
                                    for(int i = count; i > 0; i--) {
                                        Units unitStrike = new Units();
                                        unitStrike.playCard(units.get(num), num);
                                        
                                        System.out.println(unitStrike.getName() + " Attack: " + unitStrike.getAttack() + "\n");
                                        
                                        totalAttack += unitStrike.getAttack();
                                        num++;
                                    }
                                }                                
                                else {
                                    //Invalid
                                    System.out.println("Oops! Invalid input...striking nexus with availible units");
                                    int num = 1;
                                    for(int i = count; i > 0; i--) {
                                        System.out.println(units.get(num));
                                        System.out.println("Attack: \n");
                                        num++;
                                    }
                                }
                                
                                //result
                                int remainingHealth = nexus - totalAttack;
                                System.out.println("Resulting strike...\nTotal Attack: " + totalAttack + "\n" + "Nexus Remaining Health: " + remainingHealth + "\n");
                                
                                if(remainingHealth < 1) {
                                    System.out.println("You struck down the nexus!");
                                }
                                else {
                                    System.out.println("You failed to strike down the nexus");
                                }
                                
                                System.out.println("""
                                                +------------------------------------------------------+
                                                | Would you like to simulate another unit strike?      |
                                                |------------------------------------------------------|
                                                | 1) Yes                                               |
                                                | 2) No                                                |
                                                +------------------------------------------------------+
                                                """);;
                                
                                selection = scan.nextInt();//choosing yes or no to repeat
                                do{
                                    if(selection == 1) {
                                        loop = true;
                                        invalid = false;
                                    }
                                    else if(selection == 2) {
                                        loop = false;
                                        invalid = false;
                                    }
                                    else{
                                        //Error message
                                        System.out.println("Oops! Invalid input\nTry again.");
                                        invalid = true;
                                    }
                                }
                                while(invalid);
                            }
                            while(loop);
                            
                            break;
                        
                        case 3:
                            int mana = 10;
                            loop = true;
                            //cast spell
                            System.out.println("""
                                                        +-------------------------------------------------------------+
                                                        | You have selected the spell caster simulation               |
                                                        |-------------------------------------------------------------|
                                                        | You have been given 10 mana                                 |
                                                        |-------------------------------------------------------------|
                                                        | Please enter the name of a spell to begin the simulation:   |
                                                        +-------------------------------------------------------------+
                                                        """);
                            while(loop && mana > 0) {
                                
                                System.out.println("You currently have " + mana + " mana");
                                                        
                                scan.nextLine();
                                String spellName = scan.nextLine();
                                
                                Spells spellCast = new Spells();
                                spellCast.playCard(spellName, 1);
                                
                                
                                if(mana - spellCast.getCost() > 0) {
                                    mana -= spellCast.getCost();
                                    System.out.println("You have casted " + spellName + " for " + spellCast.getCost() + " mana!\n");
                                    System.out.println("The effects of this spell are as follows: \n" + spellCast.getEffect() + "\n");
                                    
                                    //Cases depending on keywords
                                    switch(spellCast.getKeyword1()) {
                                        case "Burst":
                                            System.out.println("The opponent is unable to react to this spell");
                                            break;
                                        
                                        case "Fast":
                                            System.out.println("The opponent can only respond with an equally fast spell");
                                            break;
                                            
                                        case "Fleeting":
                                            System.out.println("The effects of this spell will fade at the end of this round");
                                            break;
                                            
                                        case "Focus":
                                            System.out.println("The opponent will not be able to respond to this spell");
                                            break;
                                        
                                        case "Lurk":
                                            System.out.println("Lurkers gain +1 power!");
                                            break;
                                        
                                        case "Overwhelm":
                                            System.out.println("Your attack pieces through opponent's defenses!");
                                            break;
                                            
                                        case "Slow":
                                            System.out.println("The opponent will be able to respond to this spell");
                                            break;
                                        
                                        case "Quick Attack":
                                            System.out.println("Your selected ally will be able to attack before your opponent will be able to strike back this round!");
                                            break;
                                        
                                        case "Double Attack":
                                            System.out.println("Your selected ally will be able to attack twice this round!");
                                            break;
                                        
                                        default:
                                            break;
                                    }
                                    switch(spellCast.getKeyword2()) {
                                        case "Burst":
                                            System.out.println("The opponent is unable to react to this spell");
                                            break;
                                        
                                        case "Fast":
                                            System.out.println("The opponent can only respond with an equally fast spell");
                                            break;
                                            
                                        case "Fleeting":
                                            System.out.println("The effects of this spell will fade at the end of this round");
                                            break;
                                            
                                        case "Focus":
                                            System.out.println("The opponent will not be able to respond to this spell");
                                            break;
                                        
                                        case "Lurk":
                                            System.out.println("Lurkers gain +1 power!");
                                            break;
                                        
                                        case "Overwhelm":
                                            System.out.println("Your attack pieces through opponent's defenses!");
                                            break;
                                            
                                        case "Slow":
                                            System.out.println("The opponent will be able to respond to this spell");
                                            break;
                                        
                                        case "Quick Attack":
                                            System.out.println("Your selected ally will be able to attack before your opponent will be able to strike back this round!");
                                            break;
                                        
                                        case "Double Attack":
                                            System.out.println("Your selected ally will be able to attack twice this round!");
                                            break;
                                        
                                        default:
                                            break;
                                    }
                                    switch(spellCast.getKeyword3()) {
                                        case "Burst":
                                            System.out.println("The opponent is unable to react to this spell");
                                            break;
                                        
                                        case "Fast":
                                            System.out.println("The opponent can only respond with an equally fast spell");
                                            break;
                                            
                                        case "Fleeting":
                                            System.out.println("The effects of this spell will fade at the end of this round");
                                            break;
                                            
                                        case "Focus":
                                            System.out.println("The opponent will not be able to respond to this spell");
                                            break;
                                        
                                        case "Lurk":
                                            System.out.println("Lurkers gain +1 power!");
                                            break;
                                        
                                        case "Overwhelm":
                                            System.out.println("Your attack pieces through opponent's defenses!");
                                            break;
                                            
                                        case "Slow":
                                            System.out.println("The opponent will be able to respond to this spell");
                                            break;
                                        
                                        case "Quick Attack":
                                            System.out.println("Your selected ally will be able to attack before your opponent will be able to strike back this round!");
                                            break;
                                        
                                        case "Double Attack":
                                            System.out.println("Your selected ally will be able to attack twice this round!");
                                            break;
                                        
                                        default:
                                            break;
                                    }
                                    
                                    System.out.println("\nYour remaining mana is " + mana + "\n");
                                    
                                }
                                else {
                                    System.out.println("Oh no! You do not have enough mana to cast this spell!\n");
                                    System.out.println("\nYour remaining mana is " + mana + "\n");
                                }
                                
                                
                                
                                System.out.println("""
                                                +--------------------------------------------+
                                                | Would you like to cast another spell?      |
                                                |--------------------------------------------|
                                                | 1) Yes                                     |
                                                | 2) No                                      |
                                                +--------------------------------------------+
                                                """);;
                                
                                //Search for spell and print results                                                
                                                
                                selection = scan.nextInt();//choosing yes or no to repeat
                                do{
                                    if(selection == 1 && (mana > 0 )) {
                                        loop = true;
                                        invalid = false;
                                    }
                                    else if(selection == 1 && (mana < 1)) {
                                        loop = false;
                                        invalid = false;
                                        System.out.println("Oh no! Your mana is depleted!");
                                    }
                                    else if(selection == 2) {
                                        loop = false;
                                        invalid = false;
                                    }
                                    else{
                                        //Error message
                                        invalid = true;
                                    }
                                }
                                while(invalid);
                            }
                            
                            break;
                            
                        case 4:
                            do {
                                //use ability
                                System.out.println("""
                                                        +----------------------------------------------------------------+
                                                        | You have selected the ability usage simulation                 |
                                                        |----------------------------------------------------------------|
                                                        | Please enter the name of an ability to begin the simulation:   |
                                                        +----------------------------------------------------------------+
                                                        """);
                                                        
                                scan.nextLine();
                                String abilityName = scan.nextLine();
                                
                                Abilities abilityUse = new Abilities();
                                abilityUse.playCard(abilityName, 1);
                                
                                System.out.println("You have used the ability " + abilityName + "!\n");
                                System.out.println("The effects of this ability are as follows: \n" + abilityUse.getEffect() + "\n");
                                
                                System.out.println("""
                                                +--------------------------------------------+
                                                | Would you like to use another ability?     |
                                                |--------------------------------------------|
                                                | 1) Yes                                     |
                                                | 2) No                                      |
                                                +--------------------------------------------+
                                                """);;
                                
                                //Search for ability and print results                                                
                                                
                                selection = scan.nextInt();//choosing yes or no to repeat
                                do{
                                    if(selection == 1) {
                                        loop = true;
                                        invalid = false;
                                    }
                                    else if(selection == 2) {
                                        loop = false;
                                        invalid = false;
                                    }
                                    else{
                                        //Error message
                                        invalid = true;
                                    }
                                }
                                while(invalid);
                            }
                            while(loop);
                            break;
                        
                        default:
                            //Invalid
                            
                            break;
                    }
                    break;
                
                case 3:
                    //Done
                    
                    System.out.println("""
                        +--------------------------------------------------------+
                        | Thank you for using our Legends of Runeterra Database! |
                        +--------------------------------------------------------+
                        """);
                    
                    programRepeat = false;
                    
                    break;
                
                default:
                    //Invalid
                    System.out.println("Oops! Invalid input");
                    break;
            }
        }
        while(programRepeat);
    }
}
