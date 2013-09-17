package cn.newtouch.service;

import java.util.ArrayList;
import java.util.List;

import cn.newtouch.Util.LabelValue;

public class BookService
{

    private List<LabelValue> books = new ArrayList<LabelValue>();

    public List<LabelValue> getBooks()
    {
        books = new ArrayList<LabelValue>();
        books.add(new LabelValue("1", "book1"));
        books.add(new LabelValue("2", "book2"));
        books.add(new LabelValue("3", "book3"));
        return books;
    }
}
