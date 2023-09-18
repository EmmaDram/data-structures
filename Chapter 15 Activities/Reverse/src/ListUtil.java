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
        //dick,harry,romeo,tom
        ListIterator<String> iterator1, iterator2 = strings.listIterator();

        int size = strings.size();

        for(int i = 0; i < size; i++)
        {
            iterator1 = strings.listIterator();
            while(iterator1.hasNext())
                iterator2.next();
            iterator2.previous();

            iterator1.set(iterator2.previous());
            System.out.println(i + "\t" + strings + "\n");
        }

    }
}