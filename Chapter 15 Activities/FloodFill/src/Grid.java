public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    
    Stack <PairClass> pair = new Stack<>(); //stack that holds all the pairclass values

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        int count = 1;
        
        PairClass start = new PairClass(row, column);
        
        pair = push(start);

        //runs as long as there is at least one value in pair stack
        while(pair.size() >= 1)
            {
                //will be used as a sort of "index" value for the stack
                Pair index = pair.pop();

                
                if(pixels[index.row()][index.col()]==0)//checks for no color
                {
                    pixels[index.row()][index.col()] = count;
                    count++;
                }
                if(index.row() + 1 < 10 && pixels[index.row() + i][index.col()] == 0)//moves onto next, checks for no color
                {
                    pair.push(new PairClass(index.row() + 1, index.col()));//adds new pair to stack
                }
                if(index.col() + 1 < 10 && pixels[index.row()][index.col() + 1] == 0)//moves onto next, checks for no color
                {
                    pair.push(new PairClass(index.row(), index.col() + 1));//adds new pair to stack
                }
                if(index.row() - 1 > -1 && pixels[index.row() - 1][index.col()] == 0)//moves onto next, checks for no color
                {
                    pair.push(new PairClass(index.row() - 1, index.col()));//adds new pair to stack
                }
                if(index.col() - 1 > -1 && pixels[index.row()][index.col() - 1] == 0)//moves onto next, checks for no color
                {
                    pair.push(new PairClass(index.row(), index.col() - 1));//adds new pair to stack
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
