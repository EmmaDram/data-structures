import java.util.Stack;
import java.util.Scanner;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
    private Stack<Integer> driveway;//Stack representing the cars in the driveway.
    private Stack<Integer> street;//Stack representing the cars in the street.

    /**
      * Constructor.
    */
    public Driveway()
    {
        driveway = new Stack<>();
        street = new Stack<>();
    }


    /**
      * Add the given license plate to the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void add(int licensePlate)
    {
      //checks if license is in driveway and that driveway isn't empty, adds license
      if(!driveway.contains(licensePlate))
      {
        driveway.push(licensePlate);
        System.out.println("License added!\n");
      }
      //checks if driveway contains licenseplate and isn't empty, says already there
      else if (driveway.contains(licensePlate))
        System.out.println(licensePlate + " is already in driveway.");
    }


    /**
      * Remove the given license plate from the driveway.
      *
      * @param licensePlate number of license plate.
    */
    public void remove(int licensePlate)
    {
      //checks if license is already in driveway
      if(driveway.contains(licensePlate))
      {
        //removes plates from driveway, adds to street, until reaches licenseplate to move
        while(licensePlate!=driveway.peek() && !(driveway.size()==0))
          {
            street.push(driveway.pop());
          }
        //removes license plate from driveway
        driveway.pop();
        System.out.println("License removed!\n");
      }

      //only runs if the licenseplate isn't in the driveway
      else
      {
        System.out.println(licensePlate + " is not in the driveway.");
      }
      
    }


    /**
      * Prints the driveway and street details to the screen.
    */
    public void print()
    {
        System.out.println("In Driveway, starting at first in (one license plate per line):");
        // Print the cars in the driveway here
        System.out.println(driveway);

        System.out.println("In Street, starting at first in (one license plate per line):");
        // Print the cars in the street here
        System.out.println(street);
        System.out.println("\n\n");
    }
}