public class StackDemo
{
    public static void main(String[] args)
    {
        
        LinkedListStack stack = new LinkedListStack();

        stack.push("Tom");
        stack.push("Diana");
        stack.push("Harry");

        System.out.print("PRINTED:\t");
        while(!stack.empty())
        {
            System.out.print(stack.pop() + "\t");
        }

        System.out.println("\nEXPECTED:" + "\tHarry\tDiana\tTom");
        
    }
}
