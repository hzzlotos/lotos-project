package cn.newtouch.action;

import java.util.ArrayList;
import java.util.List;

import cn.newtouch.Util.LabelValue;
import cn.newtouch.service.BookService;

import com.opensymphony.xwork2.Action;

public class GetBooksAction implements Action
{

    private List<LabelValue> books = new ArrayList<LabelValue>();

    private int              size;

    private String           aaa   = "3";

    public String getAaa()
    {
        return aaa;
    }

    public void setAaa(String aaa)
    {
        this.aaa = aaa;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public List<LabelValue> getBooks()
    {

        return books;
    }

    public void setBooks(List<LabelValue> books)
    {

        this.books = books;
    }

    public String execute() throws Exception
    {

        BookService bs = new BookService();

        books.addAll(bs.getBooks());

        size = books.size();

        return SUCCESS;
    }
}