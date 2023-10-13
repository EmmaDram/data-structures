import java.util.*;

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    
    Stack <Pair> stack = new Stack<>(); //stack that holds all the pairclass values

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int count = 1;
        
        Pair start = new Pair(row, column);
        
        stack.push(start);

        //runs as long as there is at least one value in pair stack
        while(!stack.empty())
            {
                //will be used as a sort of "index" value for the stack
                Pair index = stack.pop();

                //current pixel
                if(pixels[index.row()][index.column()]==0)//checks for no color
                {
                    pixels[index.row()][index.column()] = count;
                    count++;
                }
                
                //north pixel
                if(index.row() > 0)
                {
                  int x = index.row() - 1;
                  int y = index.column();
                  if(pixels[x][y] == 0)
                  {
                    stack.push(new Pair(x,y));
                  }
                }
                
                //east pixel
                if(index.column() < SIZE - 1)
                {
                  int x = index.row();
                  int y = index.column() + 1;
                  if(pixels[x][y] == 0)
                  {
                    stack.push(new Pair(x,y));
                  }
                }
                
                //south pixel
                if(index.row() < SIZE - 1)
                {
                  int x = index.row() + 1;
                  int y = index.column();
                  if(pixels[x][y] == 0)
                  {
                    stack.push(new Pair(x,y));
                  }
                }
                
                //west pixel
                if(index.column() > 0)
                {
                  int x = index.row();
                  int y = index.column() - 1;
                  if(pixels[x][y] == 0)
                  {
                    stack.push(new Pair(x,y));
                  }
                }
            }
    }

    @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
