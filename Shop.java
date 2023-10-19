/**
 * @author Kamran Awan
 * This is the Shop class.
 * This class contains the variables: shopType, itemCost, statChange, operationType, and operationValue
 */
public class Shop
{
    private final String shopType;
    private int itemCost;
    private String statChange;
    private String operationType;
    private int operationValue;

    /**
     * This constructor sets the shop's variables based on the shop type in the parameters.
     * @param shopType
     */
    public Shop(String shopType)
    {
        this.shopType = shopType;
        if (shopType.equals("Healing Potion"))
        {
            statChange = "Life";
            operationType = "Add";
            operationValue = 75;
            itemCost = 25;
        }
        else if (shopType.equals("Wood Armor"))
        {
            statChange = "Defense";
            operationType = "Add";
            operationValue = 50;
            itemCost = 50;
        }
        else if (shopType.equals("Wood Sword"))
        {
            statChange = "Attack";
            operationType = "Add";
            operationValue = 50;
            itemCost = 50;
        }
        else if (shopType.equals("Iron Armor"))
        {
            statChange = "Defense";
            operationType = "Add";
            operationValue = 100;
            itemCost = 100;
        }
        else if (shopType.equals("Iron Sword"))
        {
            statChange = "Attack";
            operationType = "Add";
            operationValue = 100;
            itemCost = 100;
        }
        else if (shopType.equals("Ender Pearl"))
        {
            statChange = "Speed";
            operationType = "Add";
            operationValue = 150;
            itemCost = 200;
        }
        else if (shopType.equals("Golden Apple"))
        {
            statChange = "MaxLife";
            operationType = "Multiply";
            operationValue = 2;
            itemCost = 250;
        }
        else if (shopType.equals("Diamond Armor"))
        {
            statChange = "Defense";
            operationType = "Add";
            operationValue = 200;
            itemCost = 500;
        }
        else if (shopType.equals("Diamond Sword"))
        {
            statChange = "Attack";
            operationType = "Add";
            operationValue = 200;
            itemCost = 500;
        }
    }

    /**
     * @return shopType
     */
    public String getShopType()
    {
        return shopType;
    }

    /**
     * @return statChange
     */
    public String getStatChange()
    {
        return statChange;
    }

    /**
     * @return operationType
     */
    public String getOperationType()
    {
        return operationType;
    }

    /**
     * @return operationValue
     */
    public int getOperationValue()
    {
        return operationValue;
    }

    /**
     * @return itemCost
     */
    public int getItemCost()
    {
        return itemCost;
    }
}
