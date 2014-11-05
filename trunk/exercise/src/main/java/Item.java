/**
 * An item with a description and a part number.
 * 
 * @version 1.00 2004-08-17
 * @author Cay Horstmann
 */
public class Item
{
    private String description;

    private int    partNumber;

    /**
     * Constructs an item.
     * 
     * @param aDescription the item's description
     * @param aPartNumber the item's part number
     */
    public Item(String aDescription, int aPartNumber)
    {
        this.description = aDescription;
        this.partNumber = aPartNumber;
    }

    @Override
    @LogEntry(logger = "global")
    public boolean equals(Object otherObject)
    {
        if (this == otherObject)
        {
            return true;
        }
        if (otherObject == null)
        {
            return false;
        }
        if (this.getClass() != otherObject.getClass())
        {
            return false;
        }
        Item other = (Item) otherObject;
        return this.description.equals(other.description) && this.partNumber == other.partNumber;
    }

    /**
     * Gets the description of this item.
     * 
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }

    @Override
    @LogEntry(logger = "global")
    public int hashCode()
    {
        return 13 * this.description.hashCode() + 17 * this.partNumber;
    }

    @Override
    @TestEntry(logger = "the")
    public String toString()
    {
        return "[descripion=" + this.description + ", partNumber=" + this.partNumber + "]";
    }
}
