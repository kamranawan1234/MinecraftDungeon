import java.util.Scanner;

/**
 * @author Kamran Awan
 * This class creates the dungeon and allows the user to select the type of hero they want.
 * This class also lets the user pick the action of their hero which include:
 * interactleft, interactright, displayleft, displayright, inspectcell, displaymap, displaystats.
 * interacting left and right moves the hero to the left and right cell and let the hero interact or skip the cell.
 * display left and right displays either the left or the right cell.
 * displaying the map displays all the cells in the dungeon.
 * display stats display the stats of the hero.
 * The game keeps letting the user input the action until the hero dies which then it indicated that the game is over.
 */
public class MinecraftDungeon
{
    /**
     * This method runs the game.
     */
    public void runGame()
    {
        GameEngine gameEngine = new GameEngine();

        LinkedDungeon dungeon = new LinkedDungeon();
        dungeon.createDungeon();

        System.out.println("Enter your hero: [Steve, Alex, Herobrine]");
        Scanner input = new Scanner(System.in);
        Hero hero = new Hero(input.next().toLowerCase());
        System.out.println(hero);

        gameEngine.setHero(hero);

        while (hero.getCurrentLife() > 0)
        {
            if (dungeon.getDungeonCleared())
            {
                int floor = dungeon.getFloor();
                dungeon = new LinkedDungeon();
                dungeon.setFloor(floor);
                dungeon.createDungeon();
                gameEngine.setHero(hero);
            }

            System.out.println("\nEnter your hero's action: [InteractLeft, InteractRight, DisplayLeft, DisplayRight, InspectCell, DisplayMap, DisplayStats]");
            String actionSelected = input.next().toLowerCase();
            if (actionSelected.equals("interactleft"))
            {
                gameEngine.skipRoom("Left", dungeon);
                System.out.println("You have entered the room containing: " + dungeon.getCurrentRoom());
                System.out.println("Enter your hero's action: [Skip, Interact]");
                String action = input.next().toLowerCase();

                if (action.equals("skip") || action.equals("interact"))
                {
                    gameEngine.interact(action, "Left", dungeon);
                }
                else
                {
                    System.out.println("Incorrect input.");
                }
            }
            else if (actionSelected.equals("interactright"))
            {
                gameEngine.skipRoom("Right", dungeon);
                System.out.println("You have entered the room containing: " + dungeon.getCurrentRoom());
                System.out.println("Enter your hero's action: [Skip, Interact]");
                String action = input.next().toLowerCase();

                if (action.equals("skip") || action.equals("interact"))
                {
                    gameEngine.interact(action, "Right", dungeon);
                }
                else
                {
                    System.out.println("Incorrect input.");
                }

            }
            else if (actionSelected.equals("displayleft"))
            {
                System.out.println("Left Cell:" + dungeon.getCurrentRoom().previousRoom);
            }
            else if (actionSelected.equals("displayright"))
            {
                System.out.println("Right Cell:" + dungeon.getCurrentRoom().nextRoom);
            }
            else if (actionSelected.equals("inspectcell"))
            {
                System.out.println("Your Cell:" + dungeon.getCurrentRoom());
                System.out.println("Enter your hero's action: [Skip, Interact]");
                String action = input.next().toLowerCase();

                if (action.equals("skip") || action.equals("interact"))
                {
                    gameEngine.interact(action, "Current", dungeon);
                }
                else
                {
                    System.out.println("Incorrect input.");
                }
            }
            else if (actionSelected.equals("displaymap"))
            {
                System.out.println("Map Display:" + dungeon);
            }
            else if (actionSelected.equals("displaystats"))
            {
                System.out.println(hero);
            }
            else
            {
                System.out.println("Entered wrong action.");
            }
        }
        System.out.println("Game over, your hero has died.");
        System.out.println("Reached floor: " + dungeon.getFloor());
    }
}