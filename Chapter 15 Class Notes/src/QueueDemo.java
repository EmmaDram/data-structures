import java.util.LinkedList;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        //create a print queue of strings (using a linked list, which is a queue!)
        Queue<String> jobs = new LinkedList<>();
        jobs.add("Joe: Expense Report 2023");
        jobs.add("Cathy: Top Secret Document #5");

        System.out.println("Printing... " + jobs.remove());//first in, first out, so joe will be printed first

        jobs.add("Cathy: Really Top Secret Document #6");
        jobs.add("Joe: Grocery List");
        jobs.add("Cathy: Can I Get Fired For This?");

        System.out.println("Printing... " + jobs.remove());//prints cathy's top secret document #5

        jobs.add("Boss: Cathy's Termination Letter");
        
        //howw to print the rest of the jobs in the queue
        while(!jobs.isEmpty())
        {
            System.out.println("Pringint... " + jobs.remove());
        }
    }
}
