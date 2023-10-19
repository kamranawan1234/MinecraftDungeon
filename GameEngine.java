import java.util.Random;

/**
 * @author Kamran Awan
 * This class contains a variable hero which is the class hero that the user chose.
 * This class contains 7 methods that are used for the game engine.
 * These methods include: setHero(), doOperation(), setHeroStat(), attack(), battleMonster(), skipRoom(), and interact().
 * The setHero() method sets the hero variable in the class to the one the user chose.
 * The doOperation() method gets the operation of the object and affects the stat by it based on the difference.
 * The setHeroStat() method changes the stats of the hero based on the statType, difference and operation.
 * The attack() method manages what happens when either the monster or the hero is attaacked.
 * The battleMonster() method is what runs when the hero is fighting a monster.
 * The skipRoom() method is what runs when the user chooses to skip a room.
 * The interact() method is what runs when the user chooses to interact with a room.
 */
public class GameEngine
{
    private Hero hero;

    /**
     * Sets the hero to the one in the parameters.
     * @param hero
     */
    public void setHero(Hero hero)
    {
        this.hero = hero;
    }

    /**
     * Sets the stat based on the operation and difference.
     * @param stat
     * @param difference
     * @param operation
     * @return the stat after the operation
     */
    public int doOperation(int stat, int difference, String operation)
    {
        if (operation.equals("Add"))
        {
            stat += difference;
        }
        else if (operation.equals("Subtract"))
        {
            stat -= difference;
        }
        else if (operation.equals("Multiply"))
        {
            stat *= difference;
        }
        else if (operation.equals("Divide"))
        {
            stat /= difference;
        }
        return stat;
    }

    /**
     * Changes the hero's stat based on the difference and operation.
     * @param statType
     * @param difference
     * @param operation
     */
    public void setHeroStat(String statType, int difference, String operation)
    {
        if (statType.equals("Life"))
        {
            hero.setCurrentLife(doOperation(hero.getCurrentLife(), difference, operation));
            if (hero.getCurrentLife() > hero.getMaximumLife())
            {
                hero.setCurrentLife(hero.getMaximumLife());
            }
            System.out.println("Hero's life was changed to " + hero.getCurrentLife() + " (" + operation + " " + difference + ")");
        }
        else if (statType.equals("MaxLife"))
        {
            hero.setMaximumLife(doOperation(hero.getMaximumLife(), difference, operation));
            hero.setCurrentLife(hero.getMaximumLife());
            System.out.println("Hero's maximum life and current life were changed to " + hero.getMaximumLife() + " (" + operation + " " + difference + "  )");
        }
        else if (statType.equals("Attack"))
        {
            hero.setAttack(doOperation(hero.getAttack(), difference, operation));
            if (hero.getAttack() < 0)
            {
                hero.setAttack(0);
            }
            System.out.println("Hero's attack was changed to " + hero.getAttack() + " (" + operation + " " + difference + ")");
        }
        else if (statType.equals("Defense"))
        {

            if (operation.equals("Add") || operation.equals("Multiply"))
            {
                hero.setDefense(doOperation(hero.getDefense(), difference, operation));
                System.out.println("Hero's defense was changed to " + hero.getDefense() + " (" + operation + " " + difference + ")");
            }
            else
            {
                if (hero.getDefense() - difference >= 0)
                {
                    hero.setDefense(doOperation(hero.getDefense(), difference, operation));
                    System.out.println("Hero's defense was changed to " + hero.getDefense() + " (" + operation + " " + difference + ")");
                }
                else
                {
                    hero.setDefense(0);
                    hero.setCurrentLife(hero.getCurrentLife() - (difference - hero.getDefense()));
                    System.out.println("Hero's defense has broken and has taken damage instead.");
                }
            }

        }
        else if (statType.equals("Speed"))
        {
            hero.setSpeed(doOperation(hero.getSpeed(), difference, operation));
            if (hero.getSpeed() < 0)
            {
                hero.setSpeed(0);
            }
            System.out.println("Hero's speed was changed to " + hero.getSpeed() + " (" + operation + " " + difference + ")");
        }
        else
        {
            hero.setMoney(doOperation(hero.getMoney(), difference, operation));
            if (hero.getMoney() < 0)
            {
                hero.setMoney(0);
            }
            System.out.println("Hero's money was changed to " + hero.getMoney() + " (" + operation + " " + difference + ")");
        }
    }

    /**
     * Lets the monster or hero attack and decreases their defense and health.
     * @param attacker
     * @param monster
     */
    public void attack(String attacker, Monster monster)
    {
        if (attacker.equals("Monster"))
        {
            if (hero.getDefense() >= monster.getAttack())
            {
                hero.setDefense(hero.getDefense() - monster.getAttack());
                System.out.println("Your hero was attacked by a monster and lost defense.");
                System.out.println(hero);
            }
            else
            {
                int resultingDamage = monster.getAttack() - hero.getDefense();
                hero.setDefense(0);
                hero.setCurrentLife(hero.getCurrentLife() - resultingDamage);
                System.out.println("Your hero was attacked by a monster and took damage.");
                System.out.println(hero);
            }
        }
        else if (attacker.equals("Hero"))
        {
            if (monster.getDefense() >= hero.getAttack())
            {
                monster.setDefense(monster.getDefense() - hero.getAttack());
                System.out.println("Your hero has attacked the monster and it lost defense.");
                System.out.println(monster);
            }
            else
            {
                int resultingDamage = hero.getAttack() - monster.getDefense();
                monster.setDefense(0);
                monster.setCurrentLife(monster.getCurrentLife() - resultingDamage);
                System.out.println("Your hero attacked the a monster and it took damage.");
                System.out.println(monster);
            }
        }
    }

    /**
     * Lets the hero battle the monster, they keep battling until one of them is dead.
     * @param monster
     */
    public void battleMonster(Monster monster)
    {
        int i = 1;
        while (hero.getCurrentLife() > 0 && monster.getCurrentLife() > 0)
        {
            int getTurn = new Random().nextInt(3);
            if (getTurn == 0)
            {
                System.out.println("#" + i + ": Hero's turn");
                attack("Hero", monster);
            }
            else if (getTurn == 1)
            {
                System.out.println("#" + i + ": Monster's turn");
                attack("Monster", monster);
            }
            else
            {
                if (hero.getSpeed() > monster.getSpeed())
                {
                    System.out.println("#" + i + ": Hero's turn");
                    attack("Hero", monster);
                }
                else
                {
                    System.out.println("#" + i + ": Monster's turn");
                    attack("Monster", monster);
                }
            }
            i++;
        }
        if (hero.getCurrentLife() > 0)
        {
            System.out.println("Your hero has defeated the monster");
            hero.setMoney(hero.getMoney() + monster.getMoney());
        }
        else
        {
            System.out.println("Your hero was defeated by the monster");
        }
    }

    /**
     * Lets the hero skip a room, if the room contains a monster or a trap it has a chance of damaging the user.
     * @param direction
     * @param dungeon
     */
    public void skipRoom(String direction, LinkedDungeon dungeon)
    {
        String roomType = dungeon.getCurrentRoom().getRoomType();
        String roomClassType = dungeon.getCurrentRoom().getClassType();
        if (roomType.equals("Monster"))
        {
            Monster monster = new Monster(roomClassType);
            if (hero.getSpeed() < monster.getSpeed() + 50)
            {
                attack("Monster", monster);
            }
            else
            {
                System.out.println("The monster could not attack you.");
            }

        }
        else if (roomType.equals("Trap"))
        {
            if (new Random().nextInt(hero.getSpeed()/10 + 2) == 0)
            {
                Trap trap = new Trap(roomClassType);
                setHeroStat(trap.getStatChange(), trap.getOperationValue(), trap.getOperationType());
                System.out.println("Trap activated: " + trap.getTrapType());
                System.out.println(hero);
                dungeon.removeRoom(dungeon.getCurrentRoom());
            }
            else
            {
                System.out.println("The trap was not activated");
            }
        }

        if (direction.equals("Left"))
        {
            dungeon.setCurrentRoom(dungeon.getCurrentRoom().previousRoom);
        }
        else if (direction.equals("Right"))
        {
            dungeon.setCurrentRoom(dungeon.getCurrentRoom().nextRoom);
        }
    }

    /**
     * Lets the hero interact with a room, what happens is based on what type of room the user interacted with.
     * @param action
     * @param direction
     * @param dungeon
     */
    public void interact(String action, String direction, LinkedDungeon dungeon)
    {
        if (action.equals("skip"))
        {
            skipRoom(direction, dungeon);
        }
        else
        {
            String roomType = dungeon.getCurrentRoom().getRoomType();
            String roomClassType = dungeon.getCurrentRoom().getClassType();
            if (roomType.equals("Monster"))
            {
                Monster monster = new Monster(roomClassType);
                System.out.println("Monster fighting: " + monster.getMonster());
                battleMonster(monster);
                dungeon.removeRoom(dungeon.getCurrentRoom());
            }
            else if (roomType.equals("Item"))
            {
                Item item = new Item(roomClassType);
                setHeroStat(item.getStatChange(), item.getOperationValue(), item.getOperationType());
                System.out.println("Item picked up: " + item.getItemType());
                System.out.println(hero);
                dungeon.removeRoom(dungeon.getCurrentRoom());
            }
            else if (roomType.equals("Trap"))
            {
                Trap trap = new Trap(roomClassType);
                setHeroStat(trap.getStatChange(), trap.getOperationValue(), trap.getOperationType());
                System.out.println("Trap entered: " + trap.getTrapType());
                System.out.println(hero);
                dungeon.removeRoom(dungeon.getCurrentRoom());
            }
            else if (roomType.equals("Shop"))
            {
                Shop shop = new Shop((roomClassType));
                System.out.println("Shop entered: " + shop.getShopType() + ", Price: " + shop.getItemCost());
                if (hero.getMoney() >= shop.getItemCost())
                {
                    hero.setMoney(hero.getMoney() - shop.getItemCost());
                    setHeroStat(shop.getStatChange(), shop.getOperationValue(), shop.getOperationType());
                    System.out.println("Item purchased: " + shop.getShopType());
                    System.out.println(hero);
                    dungeon.removeRoom(dungeon.getCurrentRoom());
                }
                else
                {
                    System.out.println("You hero does not have enough money to purchase this item.");
                }
            }
            else if (roomType.equals("Exit"))
            {
                dungeon.setFloor(dungeon.getFloor() + 1);
                System.out.println("You have entered the exit.");
                System.out.println("You are now entering floor " + dungeon.getFloor());
                dungeon.setDungeonCleared(true);
            }
            else
            {
                System.out.println("This room is empty");
            }
        }

    }
}
