import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class HTMLChecker
  {
    public static void main (String[] args)
    {
      //creates variables for files to be used:
      //String file1 = "Chapter 15 Activities\\HTMLChecker\\src\\TagSample1.html";
      //String file2 = "Chapter 15 Activities\\HTMLChecker\\src\\TagSample2.html";
      String file3 = "Chapter 15 Activities\\HTMLChecker\\src\\TagSample3.html";

      //runs as long as file is able to be found, prints error if file does not exist
      try(Scanner in = newScanner(new File(file3)))
        {
          Stack<String> tags = new Stack<>();//creates stack to hold tags from file
          
          String tag = in.next();
          
          tags.push(tag);//adds html tag from file to the stack
          
          while(in.hasNext())//runs as long as there is still text left in file
            {
              tag = in.next();//finds next tag from file
              //checks that the 
              String element = tags.lastElement().substring(1,tags.lastElement().length()))
              if(tag.contains(element) && tag.contains("/"))
              {
                tags.pop();//removes html tag from the stack
              }
              else
              {
                tags.push(tag);//adds html tag to stack
              }
            }

          if(tags.size() >= 0)
          {
            System.out.println("Sequence is nested INCORRECTLY.");
          }
          else
          {
            System.out.println("Sequence is nested correctly!");
          }
          
        } catch (FileNotFoundException error)
        {
          System.out.println("ERROR: " + file3 + " is unable to be located.");
        }
    }

    
  }
