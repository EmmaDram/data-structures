import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        // the Map interface is generic:
        // the first type is the type of the key
        // the second type is the type of the values
        Map<String, Color> favColors = new HashMap<>();

        // use put to put things into the map, add key and value
        favColors.put("Hyder", Color.RED);
        favColors.put("Athena", Color.MAGENTA);
        favColors.put("Bavya", Color.BLUE);

        // two different keys can have the same value
        // same color of red
        favColors.put("Mitchell", Color.RED);

        // BUT the same key can't have two different values
        favColors.put("Athena", Color.ORANGE);

        System.out.println(favColors.get("Athena"));

        // create a set of the keys in a map
        // this is why you can't have two values attributed to one key, cus no duplicates!
        Set<String> keys = favColors.keySet();
        for (String key : keys)
        {
            System.out.println(key + "("+key.hashCode()+"): " + favColors.get(key));
            // will print out each key, its hashCode, and its value
        }


    }
}