/**
 * @author Kamran Awan
 * This is the Monster class.
 * This class contains the variables: monster, currentLife, attack, defense, speed, and money
 */
public class Monster
{
    private final String monster;
    private int currentLife;
    private int attack;
    private int defense;
    private int speed;
    private int money;

    /**
     * This constructor sets the monster's stats based on the monster type in the parameters.
     * @param monster
     */
    public Monster(String monster)
    {
        this.monster = monster;
        if (monster.equals("Zombie"))
        {
            currentLife = 35;
            attack = 10;
            defense = 5;
            speed = 2;
            money = 25;
        }
        else if (monster.equals("Skeleton"))
        {
            currentLife = 30;
            attack = 25;
            defense = 0;
            speed = 20;
            money = 50;
        }
        else if (monster.equals("Spider"))
        {
            currentLife = 50;
            attack = 15;
            defense = 15;
            speed = 25;
            money = 75;
        }
        else if (monster.equals("Creeper"))
        {
            currentLife = 65;
            attack = 100;
            defense = 0;
            speed = 1;
            money = 100;
        }
        else if (monster.equals("Wither Skeleton"))
        {
            currentLife = 85;
            attack = 55;
            defense = 10;
            speed = 55;
            money = 150;
        }
        else if (monster.equals("Witch"))
        {
            currentLife = 150;
            attack = 65;
            defense = 10;
            speed = 45;
            money = 200;
        }
        else if (monster.equals("Enderman"))
        {
            currentLife = 135;
            attack = 95;
            defense = 5;
            speed = 150;
            money = 275;
        }
        else if (monster.equals("Wither"))
        {
            currentLife = 250;
            attack = 120;
            defense = 100;
            speed = 50;
            money = 550;
        }
        else if (monster.equals("Ender Dragon"))
        {
            currentLife = 500;
            attack = 225;
            defense = 250;
            speed = 75;
            money = 1500;
        }
        else if (monster.equals("Herobrine"))
        {
            currentLife = 1000;
            attack = 1000;
            defense = 1000;
            speed = 1000;
            money = 10000;
        }
    }

    /**
     * @return monster
     */
    public String getMonster()
    {
        return monster;
    }

    /**
     * @return currentLife
     */
    public int getCurrentLife()
    {
        return currentLife;
    }

    /**
     * @return attack
     */
    public int getAttack()
    {
        return attack;
    }

    /**
     * @return defense
     */
    public int getDefense()
    {
        return defense;
    }

    /**
     * @return speed
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * @return money
     */
    public int getMoney()
    {
        return money;
    }

    /**
     * Sets the Monster's currentLife to the one in the parameters.
     */
    public void setCurrentLife(int newCurrentLife)
    {
        currentLife = newCurrentLife;
    }

    /**
     * Sets the Monster's defense to the one in the parameters.
     */
    public void setDefense(int newDefense)
    {
        defense = newDefense;
    }

    /**
     * @return the Monster's stats
     */
    public String toString()
    {
        return monster + "'s Stats:"
                + "\nCurrentHP: " + currentLife
                + "\nAtk: " + attack
                + "\nDefense: " + defense
                + "\nSpeed: " + speed
                + "\nMoney: " + money;
    }
}
