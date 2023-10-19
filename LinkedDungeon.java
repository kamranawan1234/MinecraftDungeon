import java.util.Random;

/**
 * @author Kamran Awan
 * This class operates all the functions of the dungeon.
 * This class contains 6 private variables which are:
 * head, tail, currentRoom, size, floor, and dungeonCleared.
 * The head is the first cell, the tail is the last, and the current is the one the hero is in.
 * The size is the number of cells in the dungeon, and the floor is the number of floor the hero is on.
 * The dungeonCleared variable just indicated when the hero has exited the floor.
 * This class contains 11 methods which include: getCurrentRoom(), setCurrentRoom(), getDungeonCleared(),
 * setDungeonCleared(), getFloor(), setFloor(), addRoomInFront(), getRoom(), removeRoom(), createDungeon(), and toString().
 * These methods are used to operate the dungeon.
 */
public class LinkedDungeon
{
    private Room head;
    private Room tail;
    private Room currentRoom;
    private int size = 0;
    private int floor = 1;
    private boolean dungeonCleared = false;

    /**
     * Returns the currentRoom.
     * @return currentRoom
     */
    public Room getCurrentRoom()
    {
        return currentRoom;
    }

    /**
     * Sets the currentRoom to the one in the parameters.
     * @param currentRoom
     */
    public void setCurrentRoom(Room currentRoom)
    {
        this.currentRoom = currentRoom;
    }

    /**
     * Returns true if dungeonCleared, else, false.
     * @return dungeonCleared.
     */
    public Boolean getDungeonCleared()
    {
        return dungeonCleared;
    }

    /**
     * Sets the dungeonCleared to the cleared variable in the parameters.
     * @param cleared
     */
    public void setDungeonCleared(Boolean cleared)
    {
        dungeonCleared = cleared;
    }

    /**
     * Returns the floor.
     * @return floor
     */
    public int getFloor()
    {
        return floor;
    }

    /**
     * Sets the floor to the one in the parameters.
     * @param floor
     */
    public void setFloor(int floor)
    {
        this.floor = floor;
    }

    /**
     * Adds a room to the front of the LinkedDungeon and sets its roomType and classType.
     * @param roomType
     * @param classType
     */
    public void addRoomInFront(String roomType, String classType)
    {
        Room newRoom = new Room(roomType, classType);
        if (head == null)
        {
            head = tail = newRoom;
            head.nextRoom = head.previousRoom = newRoom;
        }
        else
        {
            newRoom.nextRoom = head;
            newRoom.previousRoom = tail;
            head.previousRoom = tail.nextRoom = newRoom;
            head = newRoom;
        }
        size++;
    }

    /**
     * Gets a room from the LinkedDungeon based on the index in the parameters.
     * @param index
     * @return Room
     */
    public Room getRoom(int index)
    {
        Room current = head;
        for (int i = 0; i < index && i < size; i++)
        {
            current = current.nextRoom;
        }
        return current;
    }

    /**
     * Removes the room in the parameters from the linkedDungeon.
     * @param room
     */
    public void removeRoom(Room room)
    {
        room.previousRoom.nextRoom = room.nextRoom;
        room.nextRoom.previousRoom = room.previousRoom;

        if (room == head)
        {
            head = room.nextRoom;
        }
        if (room == tail)
        {
            tail = room.previousRoom;
        }
        currentRoom = room.nextRoom;
    }

    /**
     * Creates the dungeon and the rooms based on the number of the floor the hero is on.
     * The higher the floor, the more types of monsters, items, shops, and traps there are.
     * All the monsters, items, shops, and traps are randomized. The number of rooms depends on the floor.
     */
    public void createDungeon()
    {
        int maxSize = 5 + (floor*2);

        addRoomInFront("Exit", null);
        for (int i = 0; i < maxSize; i++)
        {
            int randomNumber = new Random().nextInt(4);
            if (randomNumber == 0)
            {
                randomNumber = new Random().nextInt(floor - 1, 2 + floor);

                if (randomNumber == 0)
                {
                    addRoomInFront("Monster", "Zombie");
                }
                else if (randomNumber == 1)
                {
                    addRoomInFront("Monster", "Skeleton");
                }
                else if (randomNumber == 2)
                {
                    addRoomInFront("Monster", "Spider");
                }
                else if (randomNumber == 3)
                {
                    addRoomInFront("Monster", "Creeper");
                }
                else if (randomNumber == 4)
                {
                    addRoomInFront("Monster", "Wither Skeleton");
                }
                else if (randomNumber == 5)
                {
                    addRoomInFront("Monster", "Witch");
                }
                else if (randomNumber == 6)
                {
                    addRoomInFront("Monster", "Enderman");
                }
                else if (randomNumber == 7)
                {
                    addRoomInFront("Monster", "Wither");
                }
                else if (randomNumber == 8)
                {
                    addRoomInFront("Monster", "Ender Dragon");
                }
                else
                {
                    addRoomInFront("Monster", "Herobrine");
                }
            }
            else if (randomNumber == 1 || randomNumber == 2)
            {
                String roomType;
                if (randomNumber == 1)
                {
                    roomType = "Item";
                }
                else
                {
                    roomType = "Shop";
                }

                if (floor > 6)
                {
                    randomNumber = new Random().nextInt(0, 10);
                }
                else
                {
                    randomNumber = new Random().nextInt(0, floor + 3);
                }


                if (randomNumber == 0)
                {
                    addRoomInFront(roomType, "Healing Potion");
                }
                else if (randomNumber == 1)
                {
                    addRoomInFront(roomType, "Wood Armor");
                }
                else if (randomNumber == 2)
                {
                    addRoomInFront(roomType, "Wood Sword");
                }
                else if (randomNumber == 3)
                {
                    addRoomInFront(roomType, "Iron Armor");
                }
                else if (randomNumber == 4)
                {
                    addRoomInFront(roomType, "Iron Sword");
                }
                else if (randomNumber == 5)
                {
                    addRoomInFront(roomType, "Ender Pearl");
                }
                else if (randomNumber == 6)
                {
                    addRoomInFront(roomType, "Golden Apple");
                }
                else if (randomNumber == 7)
                {
                    addRoomInFront(roomType, "Diamond Armor");
                }
                else if (randomNumber == 8)
                {
                    addRoomInFront(roomType, "Diamond Armor");
                }
                else
                {
                    addRoomInFront(roomType, "Lightning Stick");
                }
            }
            else
            {
                if (floor > 6)
                {
                    randomNumber = new Random().nextInt(0, 8);
                }
                else
                {
                    randomNumber = new Random().nextInt(0, floor + 2);
                }

                if (randomNumber == 0)
                {
                    addRoomInFront("Trap", "Spikes");
                }
                else if (randomNumber == 1)
                {
                    addRoomInFront("Trap", "TNT");
                }
                else if (randomNumber == 2)
                {
                    addRoomInFront("Trap", "Broken Sword");
                }
                else if (randomNumber == 3)
                {
                    addRoomInFront("Trap", "Broken Armor");
                }
                else if (randomNumber == 4)
                {
                    addRoomInFront("Trap", "Thief");
                }
                else if (randomNumber == 5)
                {
                    addRoomInFront("Trap", "Falling Sand");
                }
                else if (randomNumber == 6)
                {
                    addRoomInFront("Trap", "Lava");
                }
                else if (randomNumber == 7)
                {
                    addRoomInFront("Trap", "Void");
                }
            }
        }
        currentRoom = getRoom(maxSize/2);
    }

    /**
     * Returns all the rooms in the dungeon formatted.
     * @return Rooms
     */
    @Override
    public String toString()
    {
        Room head = this.head;
        String rooms = head.toString();

        while (head != tail)
        {
            head = head.nextRoom;
            rooms += head;
        }
        return rooms;
    }
}