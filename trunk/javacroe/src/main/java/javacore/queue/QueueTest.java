package javacore.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class QueueTest
{
    public static void main(String[] args)
    {
        // 先进先出
        Queue<String> queue = new LinkedList<String>(); // LinkedBlockingQueue;ArrayBlockingQueue
        queue.add("1");
        queue.add("4");
        queue.add("2");
        queue.add("5");
        queue.add("3");

        Queue<String> queue1 = new LinkedBlockingDeque<String>();
        queue1.add("aaa");
        // 获取但不移除此队列的头；如果此队列为空，则返回 null。
        while (null != queue.peek())
        {
            // 获取并移除此队列的头，如果此队列为空，则返回 null。
            System.out.println("======" + queue.poll() + "=======" + queue.size());
        }
    }
}