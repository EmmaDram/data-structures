import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    /*
     * first refers to the first node in this list
     * if the list is empty, first is null
     */
    private Node first;

    /**
        Constructs an empty linked list.
    */
    public LinkedList()
    {
        this.first = null;
    }



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFirst()
    {
        if(this.first == null)
        {
            throw new NoSuchElementException();
        }
        return this.first.data;//returns the DATA stored in the node, not the node itself
    }




    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst()
    {
        if(this.first == null)
        {
            throw new NoSuchElementException();
        }
        
        Object element = this.first.data;
        this.first = this.first.next;

        return element;
    }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = this.first;
        this.first = newNode;
    }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }





    //Class Node
    //node is static because it does not need access to anything in linked list
    //more of a design choice, doesn't impact much
    static class Node
    {
        public Object data;
        public Node next;
    }


    class LinkedListIterator implements ListIterator
    {
        //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;//needed in order to see if removing or setting a variable is called after next (which creates an error bc you can't do that)



        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next()
        {
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }

            previous = position;
            isAfterNext = true;
            
            //position is null when the iterator is just created, so we set position as the first node
            if(position == null)
            {
                position = first;
            }
            else
            {
                position = position.next;
            }

            return position.data;
        }

        



        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext()
        {   //return false if there are no elements in the list
            if(position == null)
            {
                return (first != null);
            }
            return position.next != null;
        }


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element)
        {
            //if position is at beginning of list, just call add first to add element
            if(position == null)//position is null at start of the list
            {
                addFirst(element);
                position = first;
            }
            else//not at the beginning of the list
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
        }






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
        public void remove(Object element)
        {
            if(!isAfterNext)
            {
                throw new IllegalStateException();
            }

            if(position == first)
            {
                removeFirst();
                position = null;
            }
            else
            {
                previous.next = position.next;//makes sure that the element is pointing to the one after the one that just got deleted
                position = previous;
            }

            isAfterNext = false;
        }







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element)
        {
            if(!isAfterNext)
            {
                throw new IllegalStateException();
            }
            position.data = element;//changing the data of the element, setting it
            //set isn't removing or adding anyting = the nodes aren't moving around so we don't need to set it to false
        }



    }//LinkedListIterator
}//LinkedList
