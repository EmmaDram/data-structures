import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
       
        ListIterator<String> iterator1 = strings.listIterator();
        String current;

        int key = 1;
        while (iterator1.hasNext())
        {
            
            current = iterator1.next();//sets variable for current name
            iterator1.remove();//removes name
            iterator1 = strings.listIterator(0);//resets iterator
            iterator1.add(current);//adds the name from previous variable to list
            iterator1 = strings.listIterator(key);//resets iterator at new spot in list
            key++;//increments counter
        }

    }
}