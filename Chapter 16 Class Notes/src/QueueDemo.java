public class QueueDemo
{
    public static void main(String[] args)
    {
        
        CircularArrayQueue queue = new CircularArrayQueue();

        System.out.print("REMOVED: ");
        queue.add("Tom");
        queue.add("Diana");
        queue.add("Harry");
        System.out.print(queue.remove() + "\t"); // remove Tom
        queue.add("Romeo");
        System.out.print(queue.remove() + "\n"); // remove Diana
        queue.add("Juliet");
        queue.add("Maria");
        queue.add("shreyas");
        queue.add("samantha");
        queue.add("ivan");
        
        System.out.print("QUEUE: ");
        while(!queue.empty())
        {
            System.out.print(queue.remove() + "\t");
        }
        
        System.out.println("\nEXPECTED OUTPUT: Tom, Diana, Harry, Romeo, Juliet, Maria");
        
    }
}
