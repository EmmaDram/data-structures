import java.util.Stack;


/*
 * notes:
 *      most common use of a stack is to undo things
 */
/**
 * This program simulates an undo stack. Note that operations
 * must be undone in the opposite order in which they are first
 * issued.
*/
public class StackDemo
{
    public static void main(String[] args)
    {
        Stack<String>commands = new Stack<>();//don't need to specify size of stack when instantiating

        //push commands onto the top of the stack
        commands.push("Insert: 'Hello'");
        commands.push("Insert: ','");
        commands.push("Insert: ' '");
        commands.push("Insert: 'World'");
        commands.push("Insert: '?'");
        commands.push("Delete: '?'");
        commands.push("Insert: '!'");

        //print the stack; top of stack is on the far right
        System.out.println(commands);

        //simulate the user pressing undo button four times
        for(int i = 0; i < 4; i++)
        {
            String command = commands.pop();
            System.out.println("Undo: " + command);
        }
            

    }
}
