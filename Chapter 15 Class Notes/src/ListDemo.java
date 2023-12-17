import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        LinkedList<String> staff = new LinkedList<>();

        //addLast method can be used to populate a list
        staff.addLast("Diana");
        staff.addLast("Harry");
        staff.addLast("Romeo");
        staff.addLast("Tom");

        //the list is currently DHRT

        /*
         * listIterator method creates a new list iterator
         * that is positioned at the head of the list
         * vertical bar (|) is used to represent iterator position
         */

         ListIterator<String> iterator = staff.listIterator(); //|DHRT

         /* next method advances the iterator to the next element in the list */
         iterator.next();//D|HRT

         /* next method also returns the element that the iterator is passing */
         String name = iterator.next(); //DH|RT
         System.out.println(name + "\t(expected result: Harry)\n");

         /* add method for iterators inserts an element at the iterator position 
          * iterator is then positioned after the element that was added
         */

         iterator.add("Juliet");//DHJ|RT
         iterator.add("Nina");//DHJN|RT

         /* remove method removes element returned by teh last call to the next or previous
          * remove method can ONLY be called once after calling next or previous
          * remove method CANNOT be called after calling add
         */

         iterator.next();//DHJNR|T
         iterator.remove();//DHJN|T

         System.out.println(staff + "\t(expected: [Diana, Harry, Juliet, Nina, Tom])\n");

         /* set method updates the element returned by the last call to
         * next or previous
         */
         iterator.previous();//DHJ|NT
         iterator.set("Albert");//DHJ|AT

         /* hasNext method returns true if the list has another element
          * often used in the condition of a while loop
          */

          iterator = staff.listIterator();//|DHJAT

        while (iterator.hasNext())
        {
            String n = iterator.next();
            if(n.equals("juliet"))//currently DHJ|AT
            {
                iterator.remove(); //is now DH|AT
            }
        }
        //enhanced for loops work with linked lists
        for(String n: staff)
        {
            System.out.print(n + " ");
        }
        System.out.println("Expected: Diana Harry Albert Tom\n");



        /* ConcurrentModificationException:
         * can't modify a linked list while also using an iterator
         * unless you use the iterator to do
         */
        iterator = staff.listIterator();//|DHAT
        while(iterator.hasNext())
        {
            String n = iterator.next();
            if (n.equals("Harry"))
            {
                //staff.remove("Diana");
            }
        }

        /* an enhanced for loop AUTOMATICALLY creates an iterator! 
         * 
         * following code will give us a ConcurrentModificationException
        */
        for(String n: staff)
        {
            if(n.equals("Harry"))
            {
                //staff.add("Charlie");
            }
        }

    }
}
