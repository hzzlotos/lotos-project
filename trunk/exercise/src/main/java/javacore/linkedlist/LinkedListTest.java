package javacore.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

import com.google.common.collect.Lists;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        LinkedList<Integer> list = Lists.newLinkedList();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        // 一、ListIterator有add()方法，可以向List中添加对象，而Iterator不能。
        // 二、ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历。但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。
        // 三、ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator 没有此功能。
        // 四、都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iterator仅能遍历，不能修改。因为ListIterator的这些功能，可以实现对LinkedList等List数据结构的操作。
        ListIterator<Integer> iterator = list.listIterator();

        // 该处再对list添加元素,如果不重新获取list的迭代器 while报错 因为已经更改了list了
        System.out.println(iterator.next());
        list.add(4);
        iterator = list.listIterator();
        while (iterator.hasNext())
        {
            System.out.println("======" + iterator.next());
        }

        // 对此可以使用iterator的add
        iterator = list.listIterator();
        System.out.println(iterator.next());
        iterator.add(5); // 而此时添加的位置则是迭代器所在的位置+1
        iterator = list.listIterator();
        while (iterator.hasNext())
        {
            System.out.println("-------" + iterator.next());
        }

    }
}
