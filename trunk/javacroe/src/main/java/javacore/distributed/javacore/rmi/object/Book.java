package javacore.distributed.javacore.rmi.object;

/**
 * A book is a product with an ISBN number.
 * 
 * @version 1.0 2007-10-09
 * @author Cay Horstmann
 */
public class Book extends Product
{
    public Book(String title, String isbn, double price)
    {
        super(title, price);
        this.isbn = isbn;
    }

    @Override
    public String getDescription()
    {
        return super.getDescription() + " " + this.isbn;
    }

    private String isbn;
}
