package cn.newtouch.getlevel.tree;

public class Tree<T>
{
    private Node<T> root;

    private int     num;

    public int getNum()
    {
        return this.num;
    }

    public Tree()
    {
        this.root = new Node<T>(0, null);
    }

    public Node<T> getRoot()
    {
        return this.root;
    }

    public void setRoot(Node<T> root)
    {
        this.root = root;
    }

    public Node<T> find(T value)
    {
        if (null == value)
        {
            return this.root;
        }
        return this.find(this.root.getFirstChildren(), value);
    }

    private Node<T> find(Node<T> origin, T value)
    {
        if (null == origin.getNext().getValue() && null == origin.getFirstChildren().getValue())
        {
            return null;
        }
        if (origin.getValue().equals(value))
        {
            return origin;
        }

        Node<T> result = null;
        result = this.find(origin.getNext(), value);
        if (null == result)
        {
            result = this.find(origin.getFirstChildren(), value);
        }
        return result;
    }

    private void addByParent(Node<T> parent, T value)
    {
        if (null == parent.getFirstChildren())
        {
            Node<T> t = new Node<T>(parent.getLevel() + 1, value);
            parent.setFirstChildren(t);
        }
        else
        {
            Node<T> last = this.findByLast(parent.getFirstChildren());
            Node<T> t = new Node<T>(parent.getLevel() + 1, value);
            last.setNext(t);
        }
    }

    private Node<T> findByLast(Node<T> last)
    {
        if (null == last.getNext())
        {
            return last;
        }
        return this.findByLast(last.getNext());
    }

    public void insert(T parent, T value)
    {
        if (null == value)
        {
            return;
        }
        Node<T> parentNode = this.find(parent);
        if (null == parentNode)
        {
            return;
        }
        this.addByParent(parentNode, value);
        this.num++;
    }
}