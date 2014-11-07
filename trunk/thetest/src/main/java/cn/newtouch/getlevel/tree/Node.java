package cn.newtouch.getlevel.tree;

public class Node<T>
{
    private Node<T> firstChildren;

    private int     level;

    private Node<T> next;

    private T       value;

    public Node()
    {
    }

    public Node(int level, T value)
    {
        this.level = level;
        this.value = value;
    }

    public Node<T> getFirstChildren()
    {
        return this.firstChildren;
    }

    public int getLevel()
    {
        return this.level;
    }

    public Node<T> getNext()
    {
        return this.next;
    }

    public T getValue()
    {
        return this.value;
    }

    public void setFirstChildren(Node<T> firstChildren)
    {
        this.firstChildren = firstChildren;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    public void setValue(T value)
    {
        this.value = value;
    }
}