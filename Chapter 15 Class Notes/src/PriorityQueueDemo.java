import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        //create a priority queue of to-do items
        //uses a WorkOrder class, which has a message ID that is used to determine priority
        //a priority queue can only store Comparable objects (strings, integer wrapper class, etc.)
        Queue<WorkOrder> toDo = new PriorityQueue<>();
        
        toDo.add(new WorkOrder(3, "Water Plants"));
        toDo.add(new WorkOrder(2, "Make Dinner"));
        toDo.add(new WorkOrder(2, "Walk Dog"));
        toDo.add(new WorkOrder(9, "Play Video Games"));
        toDo.add(new WorkOrder(1, "Study For Chapter 15 Exam!!!"));

        //objects added to a priority queue are stored in priority order
        System.out.println(toDo);
        
        while(toDo.size()>0)
        {
            System.out.println(toDo.remove());
        }
    }
}

//backtracking will not be on the test
