import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> namesGrades = new HashMap<>();


        boolean done = false;
        while(!done)
        {
            System.out.println("\nA)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                System.out.println("Student name: ");
                String name = in.next();
                System.out.println("Student's grade: ");
                String grade = in.next();
                namesGrades.put(name, grade);
                System.out.println("Student added!\n");
            } else if (input.equals("R"))
            {
                System.out.println("Student name: ");
                String name = in.next();
                namesGrades.remove(name);
                System.out.println("Student removed!\n");
            } else if (input.equals("M"))
            {
                System.out.println("Student name: ");
                String name = in.next();
                System.out.println("Modified grade: ");
                String newGrade = in.next();
                namesGrades.put(name, newGrade);
                System.out.println("Student's grade modified!\n");
            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = namesGrades.keySet();
                for (String key : keys)
                {
                    System.out.println("Student: " + key + "\tGrade: " + namesGrades.get(key));
                }
                System.out.println();
            }
            else
            {
                done = true;
            }
        }
    }
}
