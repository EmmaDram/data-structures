import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

import java.util.Queue;
/**
 * Implement a to do list. Tasks have a priority between 
 * 1 and 9 (with 1 being most urgent), and a description.
 * When the user enters the command 'add priority description', 
 * the program adds a new task. When the user enters next, 
 * the program removes and prints the most urgent task. 
 * The quit command quits the program. 
 * Use a priority queue in your solution.
*/
public class ToDoList
{
    // Instance variable(s)
    Queue<Task> tasks;//
    private Scanner in = new Scanner(System.in);

    /**
     * Constructor
    */
    public ToDoList()
    {
        tasks = new PriorityQueue<>();
    }

    /**
     * Display a menu and accepts commands.
     */
    public void run()
    {
        String option = "";
        System.out.println("To Do List - Please enter an option");
        System.out.println("     add priority description (add a new task)");
        System.out.println("     next (remove and print most urgent task)");
        System.out.println("     quit (exit this program)");
        System.out.println();
        
        
        
        do
        {
            System.out.print("> ");
            option = in.nextLine();
            if (option.startsWith("add"))
            {
                addTask(option);
            } else if (option.equals("next"))
            {
                nextTask();
            }
        } 
        while (! option.equals("quit"));
    }
    
    /**
     * Parse the add option line.
     *
     * @param optionStr the option line
    */
    public void addTask(String optionStr) throws InputMismatchException
    {

        Scanner words = new Scanner(optionStr);
        

        words.next();
        String priority = words.next();
        String task = words.nextLine();
        int priority2 = 0;

        if(priority.matches("[0-9]+"))
        {
            priority2 = Integer.parseInt(priority);
        }
        

        if(priority2<1 || priority2>9)
        {
            System.out.println("The priority must be an integer between 1 and 9.");
        }
        else
        {
            Task newTask = new Task(priority2,task);
            tasks.add(newTask);
        }
}

    /**
     * Get the next highest priority task and
     * display the description to the user.
    */
    public void nextTask()
    {        
        if (tasks.size() == 0)
        {
            System.out.println("There are no tasks in the list.");
        }
        else
        {
            System.out.println(tasks.remove().getDescription());
        }
    
    }
}