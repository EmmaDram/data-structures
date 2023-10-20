import java.util.NoSuchElementException;

/**
 * An implementation of a stack as a sequence of nodes.
*/
public class LinkedListStack
{
    private Node first;

    /**
     * Constructs an empty stack.
    */
    public LinkedListStack()
    {
        first = null;
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to add
    */

    public void push(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;//next element of this list will be what was previously on top of the stack
        this.first = newNode;//first will be changed to the new node that was pushed onto the stack
    }






    /**
        Removes the element from the top of the stack.
        @return the removed element
    */
    public Object pop()
    {
        if(this.empty())
        {
            throw new NoSuchElementException();
        }

        Object element = this.first.data;
        this.first = this.first.next;//top element is next element to accomodate for the removed item
        return element;
    }







    /**
     * Checks whether this stack is empty.
     *
     * @return true if the stack is empty
    */
    public boolean empty()
    {
        return (this.first == null);
    }







    


    static class Node
    {
        public Object data;
        public Node next;
    }
}
