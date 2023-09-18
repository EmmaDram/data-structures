import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Business utility methods.
*/
public class Business
{
    /**
      * Removes every nth element from the linked list
      *
      * @param employeeNames the linked list to remove from
      * @param n                 the parameter to determine "nth"
     */
    public static void downsize(LinkedList<String> employeeNames, int n)
    {

        //dick, harry, romeo, juliet
        ListIterator <String> iterator = employeeNames.listIterator();
        int size = employeeNames.size();
        for(int i = 1; i <= size ; i++){
            iterator.next();
            if(i % n == 0){
                iterator.remove();
                }
            }
            
        }
    }