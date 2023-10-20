import java.util.NoSuchElementException;

/**
    An implementation of a queue as a circular array.
*/
public class CircularArrayQueue
{
    private Object[] elements;
    private int head, tail;//their LOCATIONS in the array are changing; the data is technically staying in place but just getting overwritten
    private int currentSize;
    //private data


    //queue is initially empty; though array behind queue is of size 5, the actual queue itself is empty
    //size of the array is not necessarily how many elements are in the queue


    /**
        Constructs an empty queue.
    */
    public CircularArrayQueue()
    {
        final int INITIAL_SIZE = 5;
        this.elements = new Object[INITIAL_SIZE];
        this.head = 0;
        this.tail = 0;
        this.currentSize = 0;//nothing in the array   
    }






    /**
        Checks whether this queue is empty.
        @return true if this queue is empty
    */
    public boolean empty()
    {
        return (this.currentSize == 0);
    }



    /**
        Adds an element to the tail of this queue.
        @param newElement the element to add
    */
    public void add(Object element)
    {
        this.growIfNecessary();
        this.currentSize++;
        this.elements[this.tail] = element;
        this.tail++;

        this.tail %= this.elements.length;//if it's divisible by the length of the array, it will equal 0; will thus wrap around/get sent back to 0
    }




    /**
        Removes an element from the head of this queue.
        @return the removed element
    */
    public Object remove()
    {
        if(this.empty())
        {
            throw new NoSuchElementException();
        }
        //as we remove things, size will go down by one
        this.currentSize--;
        Object element = this.elements[this.head];//temporary object

        //move the head like we did with the tail in add()
        this.head = (this.head + 1) % this.elements.length;//same steps as add() but in one line

        return element;//object that was removed
    }





    /**
        Grows the element array if the current size equals the capacity.
    */
    private void growIfNecessary()
    {
        
        if(this.currentSize == this.elements.length)
        {
            Object[] newElements = new Object[2 * this.elements.length];
            for(int i = 0; i < this.elements.length; i++)
            {
                newElements[i] = this.elements[(head + i) % this.elements.length];
            }
            this.elements = newElements;
            this.head = 0;
            this.tail = this.currentSize;
        }
        
    }




}//CircularArrayQueue
