/**
 * @author Kamran Awan
 * This is the Hero class.
 * This class contains the variables: hero, maximumLife, currentLife, attack, defense, speed, and money
 */
public class Hero
{
    private final String hero;
    private int maximumLife;
    private int currentLife;
    private int attack;
    private int defense;
    private int speed;
    private int money;

    /**
     * This constructor sets the hero's stats based on the hero type in the parameters.
     * @param hero
     */
    public Hero(String hero)
    {
        this.hero = hero;
        if (hero.equals("steve"))
        {
            maximumLife = 100;
            currentLife = 100;
            attack = 65;
            defense = 0;
            speed = 50;
            money = 0;
        }
        else if (hero.equals("alex"))
        {
            maximumLife = 80;
            currentLife = 80;
            attack = 50;
            defense = 0;
            speed = 75;
            money = 0;
        }
        else if (hero.equals("herobrine"))
        {
            maximumLife = 1000;
            currentLife = 1000;
            attack = 1000;
            defense = 1000;
            speed = 1000;
            money = 1000;
        }
    }

    /**
     * @return maximumLife
     */
    public int getMaximumLife()
    {
        return maximumLife;
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
     * Sets the Hero's maximumLife to the one in the parameters.
     */
    public void setMaximumLife(int newMaximumLife)
    {
        maximumLife = newMaximumLife;
    }

    /**
     * Sets the Hero's currentLife to the one in the parameters.
     */
    public void setCurrentLife(int newCurrentLife)
    {
        currentLife = newCurrentLife;
    }

    /**
     * Sets the Hero's attack to the one in the parameters.
     */
    public void setAttack(int newAttack)
    {
        attack = newAttack;
    }

    /**
     * Sets the Hero's defense to the one in the parameters.
     */
    public void setDefense(int newDefense)
    {
        defense = newDefense;
    }

    /**
     * Sets the Hero's speed to the one in the parameters.
     */
    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }

    /**
     * Sets the Hero's money to the one in the parameters.
     */
    public void setMoney(int newMoney)
    {
        money = newMoney;
    }

    /**
     * @return the Hero's stats
     */
    public String toString()
    {
        return hero + "'s Stats:"
                + "\nMaxHP: " + maximumLife
                + "\nCurrentHP: " + currentLife
                + "\nAtk: " + attack
                + "\nDefense: " + defense
                + "\nSpeed: " + speed
                + "\nMoney: " + money;
    }
}
