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
            System.out.println("Cannot open: " + fileName);
        }






        //create the list of sets for each row (this.rows)
        //each row will be its own set
        this.rows = new ArrayList<Set<Integer>>();
        this.rows = rows;
        for(int row = 0; row < this.grid.length; row++)
        {
            Set<Integer> setRow = new HashSet<Integer>();

            for(int col = 0; col < this.grid[0].length; col++)
            {
                setRow.add(this.grid[row][col]);
            }
            this.rows.add(setRow);
        }







        // create the list of sets for each col (this.cols)   //each column will be its own set
        this.cols = new ArrayList<Set<Integer>>();
        this.cols = cols;
        for(int j = 0; j < this.grid.length; j++)
        {
            Set<Integer> setCols = new HashSet<Integer>();
            for(int k = 0; k < this.grid[0].length; k++)
            {
                setCols.add(this.grid[0][k]);
            }
            this.cols.add(setCols);
        }


        // create the list of sets for each square (this.squares)   //create a set for all the individual squares
        /* the squares are added to the list row-by-row:
            0 1 2
            3 4 5
            6 7 8
         */
        this.squares = new ArrayList<Set<Integer>>();
        this.squares = squares;
        Set<Integer> setSquares = new HashSet<Integer>();
        
        for(int j = 0; j < this.grid.length; j++)
        {
            for(int k = 0; k < this.grid[0].length; k++)
            {
                if(k<3)
                {
                    setSquares.add(this.grid[j][k]); setSquares.add(this.grid[j][k+1]); setSquares.add(this.grid[j][k+2]);
                    setSquares.add(this.grid[j+1][k]); setSquares.add(this.grid[j+1][k+1]); setSquares.add(this.grid[j+1][k+2]);
                    setSquares.add(this.grid[j+2][k]); setSquares.add(this.grid[j+2][k+1]); setSquares.add(this.grid[j+2][k+2]);
                    this.squares.add(setSquares);
                }
                else if(k<6)
                {
                    setSquares.add(this.grid[j][k]); setSquares.add(this.grid[j][k+1]); setSquares.add(this.grid[j][k+2]);
                    setSquares.add(this.grid[j+1][k]); setSquares.add(this.grid[j+1][k+1]); setSquares.add(this.grid[j+1][k+2]);
                    setSquares.add(this.grid[j+2][k]); setSquares.add(this.grid[j+2][k+1]); setSquares.add(this.grid[j+2][k+2]);
                    this.squares.add(setSquares);
                }
                else if(k<9)
                {
                    setSquares.add(this.grid[j][k]); setSquares.add(this.grid[j][k+1]); setSquares.add(this.grid[j][k+2]);
                    setSquares.add(this.grid[j+1][k]); setSquares.add(this.grid[j+1][k+1]); setSquares.add(this.grid[j+1][k+2]);
                    setSquares.add(this.grid[j+2][k]); setSquares.add(this.grid[j+2][k+1]); setSquares.add(this.grid[j+2][k+2]);
                    this.squares.add(setSquares);
                break;
                }
            }
            break;
        }

        // create a hash set for [1..9] (this.nums)   //possible values for sudoku numbers
        this.nums = new HashSet<Integer>();
        this.nums = nums;
        for(int i = 1; i <= 9; i++)
        {
            nums.add(i);
        }




        // visually inspect that all the sets are correct
        for (int row = 0; row < N; row++) {
            //System.out.println("row " + row + ": " + this.rows.get(row));
            System.out.print(this.rows.get(row));
        }
        System.out.println();
        for (int col = 0; col < N; col++) {
            //System.out.println("col " + col + ": " + this.cols.get(col));
            System.out.print(this.cols.get(col));
        }System.out.println();
        for (int square = 0; square < N; square++) {
            //System.out.println("square " + square + ": " + this.squares.get(square));
            System.out.print(this.squares.get(square));
        }System.out.println();
        System.out.println(this.nums);
    }




    /*
     * returns true if it has finished solving the puzzle
     */
    public boolean solve() {
        // find an empty location, if any
        boolean finished = true;
        int nextRow = -1;
        int nextCol = -1;
        for (int row = 0; row < N && finished; row++) {
            for (int col = 0; col < N && finished; col++) {
                if (this.grid[row][col] == 0) {
                    finished = false;
                    nextRow = row;
                    nextCol = col;
                }
            }
        }

        // the board is complete; we solved it
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
        
        // ...

        // if there are no possible numbers, we cannot solve the board in its current state
        if (possibleNums.isEmpty()) {
            return false;
        }

        // try each possible number
        for (Integer possibleNum : possibleNums) {
            // update the grid and all three corresponding sets with possibleNum
            // ...

            // recursively solve the board
            if (this.solve()) {
                // the board is solved!
                return true;
            } else {
                /*
                 Undo the move before trying another possible number by setting the corresponding
                 element in the grid back to 0 and removing possibleNum from all three corresponding
                 sets.
                 */
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
        System.out.println(solver);
        if (solver.solve()) {
            System.out.println("Solved!");
            System.out.println(solver);
        } else {
            System.out.println("Unsolveable...");
        }
    }
}