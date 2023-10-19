/**
 * @author Kamran Awan
 * This is the Item class.
 * This class contains the variables: itemType, statChange, operationType, and, operationValue
 */
public class Item
{
    private final String itemType;
    private String statChange;
    private String operationType;
    private int operationValue;

    /**
     * This constructor sets the item's variables based on the item type in the parameters.
     * @param itemType
     */
    public Item(String itemType)
    {
        this.itemType = itemType;
        if (itemType.equals("Healing Potion"))
        {
            statChange = "Life";
            operationType = "Add";
            operationValue = 75;
        }
        else if (itemType.equals("Wood Armor"))
        {
            statChange = "Defense";
            operationType = "Add";
            operationValue = 50;
        }
        else if (itemType.equals("Wood Sword"))
        {
            statChange = "Attack";
            operationType = "Add";
            operationValue = 50;
        }
        else if (itemType.equals("Iron Armor"))
        {
            statChange = "Defense";
            operationType = "Add";
            operationValue = 100;
        }
        else if (itemType.equals("Iron Sword"))
        {
            statChange = "Attack";
            operationType = "Add";
            operationValue = 100;
        }
        else if (itemType.equals("Ender Pearl"))
        {
            statChange = "Speed";
            operationType = "Add";
            operationValue = 150;
        }
        else if (itemType.equals("Golden Apple"))
        {
            statChange = "MaxLife";
            operationType = "Multiply";
            operationValue = 2;
        }
        else if (itemType.equals("Diamond Armor"))
        {
            statChange = "Defense";
            operationType = "Add";
            operationValue = 200;
        }
        else if (itemType.equals("Diamond Sword"))
        {
            statChange = "Attack";
            operationType = "Add";
            operationValue = 200;
        }
        else if (itemType.equals("Lightning Stick"))
        {
            statChange = "Attack";
            operationType = "Add";
            operationValue = 1000;
        }
    }

    /**
     * @return itemType
     */
    public String getItemType()
    {
        return itemType;
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
}
