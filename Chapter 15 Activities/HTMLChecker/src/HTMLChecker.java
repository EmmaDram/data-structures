import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class HTMLChecker
  {
    public static void main (String[] args)
    {
      //creates variables for files to be used:
      String testFile = "TagSample1.html";
      //String testFile = "TagSample2.html";
      //String testFile = "TagSample3.html";

      //runs as long as file is able to be found, prints error if file does not exist
      try(Scanner in = new Scanner(new File(testFile)))
        {
          //creates stack to hold tags from file
          Stack<String> tags = new Stack<>();
          
          String tag = in.next();
          //adds html tag from file to the stack
          tags.push(tag);
          
          //runs as long as there is still text left in file
          while(in.hasNext())
            {
              //finds next tag from file
              tag = in.next();
              if(tag.contains("/"))
              {
                String matchingTag = tag.replace("/","");
                if(matchingTag.equals(tags.peek()))
                {
                  //removes html tag from the stack
                  tags.pop();
                }
                else
                {
                  // closing tag does not match the top of stack
                  break;
                }
              }
              else
              {
                //adds html tag to stack
                tags.push(tag);
              }
            }

          if(tags.size() > 0)
          {
            System.out.println("Sequence in " + testFile + " is nested INCORRECTLY.");
          } 
          else
          {
            System.out.println("Sequence in " + testFile + " is nested CORRECTLY");
          }
          
        } catch (FileNotFoundException error)
        {
          System.out.println("ERROR: " + testFile + " is unable to be located.");
        }
    }
  }
