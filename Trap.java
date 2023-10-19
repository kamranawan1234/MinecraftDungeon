/**
 * @author Kamran Awan
 * This is the Trap class.
 * This class contains the variables: trapType, statChange, operationType, operationValue
 */
public class Trap
{
    private final String trapType;
    private String statChange;
    private String operationType;
    private int operationValue;

    /**
     * This constructor sets the trap's variables based on the trap type in the parameters.
     * @param trapType
     */
    public Trap(String trapType)
    {
        this.trapType = trapType;
        if (trapType.equals("Spikes"))
        {
            statChange = "Defense";
            operationType = "Subtract";
            operationValue = 50;
        }
        else if (trapType.equals("TNT"))
        {
            statChange = "Defense";
            operationType = "Divide";
            operationValue = 2;
        }
        else if (trapType.equals("Broken Sword"))
        {
            statChange = "Attack";
            operationType = "Divide";
            operationValue = 2;
        }
        else if (trapType.equals("Broken Armor"))
        {
            statChange = "Defense";
            operationType = "Divide";
            operationValue = 2;
        }
        else if (trapType.equals("Thief"))
        {
            statChange = "Money";
            operationType = "Divide";
            operationValue = 2;
        }
        else if (trapType.equals("Falling Sand"))
        {
            statChange = "Defense";
            operationType = "Subtract";
            operationValue = 100;
        }
        else if (trapType.equals("Lava"))
        {
            statChange = "Defense";
            operationType = "Subtract";
            operationValue = 150;
        }
        else if (trapType.equals("Void"))
        {
            statChange = "Life";
            operationType = "Subtract";
            operationValue = 9999999;
        }
    }

    /**
     * @return trapType
     */
    public String getTrapType()
    {
        return trapType;
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
