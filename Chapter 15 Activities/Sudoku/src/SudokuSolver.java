import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SudokuSolver
{
    private final int M = 3;//how many squares there are on one side (this is a 3 by 3 squares sudoku)
    private final int N = M * M;//how many rows/columns there are
    private int[][] grid;//2d array, read from file
    private ArrayList<Set<Integer>> rows;//comprised of 9 sets
    private ArrayList<Set<Integer>> cols;//comprised of 9 sets
    private ArrayList<Set<Integer>> squares;//will store all the squares (should be 9 of them)
    private Set<Integer> nums;//possible values of the numbers

    public SudokuSolver(String fileName)
    {
        // read the puzzle file
        try (Scanner in = new Scanner(new File(fileName)))
        {
            this.grid = new int[N][N];

            for (int row = 0; row < N; row++)
            {
                String line = in.next();

                for (int col = 0; col < N; col++)
                {
                    String strVal = line.substring(col, col + 1);
                    int number;
                    if (strVal.equals("x"))
                    {
                        number = 0;
                    } else
                    {
                        number = Integer.parseInt(strVal);
                    }
                    this.grid[row][col] = number;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open: " + fileName);
        }






        //create the list of sets for each row (this.rows)
        //each row will be its own set
        this.rows = new ArrayList<Set<Integer>>();
        int length = this.grid.length;
        for(int add = 0; add < length; add++)
        {
            Set newSet = new HashSet<Integer>();
            this.rows.add(newSet);
        }

        for(int row = 0; row < length; row++)
        {
            for(int col = 0; col < this.grid[0].length; col++)
            {
                int addNum = this.grid[row][col];
                this.rows.get(row).add(addNum);
            }
        }







        // create the list of sets for each col (this.cols)   //each column will be its own set
        this.cols = new ArrayList<Set<Integer>>();
        for(int add = 0; add < length; add++)
        {
            Set newSet = new HashSet<Integer>();
            this.rows.add(newSet);
        }
        for(int col = 0; col < length; col++)
        {
            for(int row = 0; col < this.grid[0].length; row++)
            {
                int addNum = this.grid[row][col];
                this.rows.get(col).add(addNum);
            }
        }






        
        // create the list of sets for each square (this.squares)   //create a set for all the individual squares
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        this.squares = new ArrayList<Set<Integer>>();
        for(int add = 0; add < N; add++)
            {
                Set newSet = new HashSet<Integer>();
                this.squares.add(newSet);
            }//creates sets that will be populated in next for loop
        for(int row = 0; row < length; row++)//adds values to the square set
            {
                for(int col = 0; col < length; col++)
                    {
                        int squareValue = ((row/3)*3) + (col/3);
                        int addValue = this.grid[row][col];
                        this.squares.get(row).add(addValue);
                    }
            }








        
        // create a hash set for [1..9] (this.nums)   //possible values for sudoku numbers
        this.nums = new HashSet<Integer>();
        this.nums = nums;
        for(int i = 1; i <= 9; i++)
        {
            nums.add(i);
        }
        //displays the rows, columns, and square values
    for (int row = 0; row < N; row++)
        {
            int rowNum = row + 1;
            System.out.println("row " + rowNum + " = " + this.rows.get(row));
        }
        for (int col = 0; col < N; col++) {
            int colNum = col + 1;
            System.out.println("col " + colNum + " = " + this.cols.get(col));
        }
        for (int square = 0; square < N; square++) {
            int squareNum = square + 1;
            System.out.println("square " + squareNum + " = " + this.squares.get(square));
        }
        System.out.println(this.nums);
    }








    
    /*
     * returns true if it has finished solving the puzzle
     */
    public boolean solve() {
        boolean done = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && done; row++) {
            for (int col = 0; col < N && done; col++) {
                if (this.grid[row][col] == 0) {
                    done = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }





        
        // solved
        if (finished)
        {
            return true;
        }

        // get all possible numbers for the row and column we are trying to populate
        /*
            Create a new set based on the this.nums and remove all elements in the sets
            corresponding to nextRow, nextCol, and the corresponding square (use the
            removeAll method).
                                            //figure out how to calculate exactly where that square is, involves using the size of the m variable

            Properly indexing the squares list of sets is tricky. Verify that your
            algorithm is correct.
         */
        Set<Integer> possibleNums = new HashSet<Integer>();
        
        possibleNums.addAll(this.nums);
        possibleNums.removeAll(this.rows.get(nextRow));
        possibleNums.removeAll(this.cols.get(nextCol));
        
        int nextS;
        
        nextS = (nextRow / M) * M + (nextCol / M);
        possibleNums.removeAll(this.squares.get(nextS));

        // no possible nums = cannot solve board
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleVal : possibleNums) {
            //update grid, all three corresponding sets with possibleVal
            grid[nextRow][nextCol] = possibleVal;
            this.rows.get(nextRow).add(possibleVal);
            this.cols.get(nextCol).add(possibleVal);
            this.squares.get(nextS).add(possibleVal);
            // ...

            // recursively solve the board
            if (this.solve()) {
                //solved
                return true;
            } else {
                /*
                 Undo the move, try another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
                grid[nextRow][nextCol] = 0;
                this.rows.get(nextRow).remove(possibleVal);
                this.cols.get(nextCol).remove(possibleVal);
                this.squares.get(nextS).remove(possibleVal);
                // ...
            }
        }

        return false;
    }

    public String toString() {
        String str = "";
        for (int[] row : grid) {
            for (int val : row) {
                str += val + "\t";
            }
            str += "\n";
        }

        return str;
    }

    public static void main(String[] args) {
        String fileName = "Chapter 15 Activities/Sudoku/src/puzzle1.txt";

        SudokuSolver solver = new SudokuSolver(fileName);

         System.out.println("FILE NAME = " + solver);
        if (solver.solve()) {
            System.out.println("The board is solved. Congratulations!");
            System.out.println(solver);
        } else {
            System.out.println("The board is unsolvable... sorry!");
        }
    }
}
