/**
 * @author Kamran Awan
 * This class is the rooms in the LinkedDungeon.
 * This class contains four variables: roomType, classType, nextRoom, previousRoom.
 * This class contains a constructor and three methods.
 * The methods include: toString(), getRoomType, and getClassType().
 */
public class Room
{
    private final String roomType;
    private final String classType;
    public Room nextRoom;
    public Room previousRoom;

    /**
     * Sets the roomType and classType to the ones in the parameters.
     * @param roomType
     * @param classType
     */
    public Room(String roomType, String classType)
    {
        this.roomType = roomType;
        this.classType = classType;
    }

    /**
     * @return the Room in String Format.
     */
    @Override
    public String toString()
    {
        if (classType == null)
        {
            return  " [" + roomType + "] ";
        }
        return " [" + roomType + ": " + classType + "] ";
    }

    /**
     * @return roomType
     */
    public String getRoomType()
    {
        return roomType;
    }

    /**
     * @return classType
     */
    public String getClassType()
    {
        return classType;
    }
}
