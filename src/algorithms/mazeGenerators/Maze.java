package algorithms.mazeGenerators;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * The Maze class represents a maze with a grid of cells.
 * Each cell can have a value, and the maze has a start and goal position.
 */
public class Maze implements Serializable {
    private int[][] grid;
    private Position start ;
    private Position goal;
    private int rows;
    private int columns;

    /**
     * Constructs a Maze object with the specified number of rows and columns.
     * Initializes the grid and randomly sets the start and goal positions on the edges of the maze.
     *
     * @param rows the number of rows in the maze
     * @param columns the number of columns in the maze
     */



    public Maze(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        grid = new int[rows][columns];
        Random rand = new Random();
        int max = Math.min(rows, columns);
        // Set the start and goal positions
        // Set the start position to be in the first row and a random column
        // Set the goal position to be in a random row and the last column
        int Sidesrand= rand.nextInt(4);
        int Linerand= rand.nextInt(max-1);

        //Set the start position randomly on the sides of the maze
        switch (Sidesrand)
        {
            case 0:
                //set in on the first row and a random column
                this.setStartPosition(new Position(0, Linerand));
                break;
            case 1:
                //set in on the first column and a random row
                this.setStartPosition(new Position(Linerand, 0));
                break;
            case 2:
                //set in on the last row and a random column
                this.setStartPosition(new Position(rows-1, Linerand));
                break;
            case 3:
                //set in on the last column and a random row
                this.setStartPosition(new Position(Linerand, columns-1));
                break;
        }
        //Set the goal position randomly on the sides of the maze
        Sidesrand= rand.nextInt(4);
        Linerand= rand.nextInt(max-1);
        switch (Sidesrand)
        {
            case 0:
                //set in on the first row and a random column
                this.setGoalPosition(new Position(0, Linerand));
                break;
            case 1:
                //set in on the first column and a random row
                this.setGoalPosition(new Position(Linerand, 0));
                break;
            case 2:
                //set in on the last row and a random column
                this.setGoalPosition(new Position(rows-1, Linerand));
                break;
            case 3:
                //set in on the last column and a random row
                this.setGoalPosition(new Position(Linerand, columns-1));
                break;
        }
    }

    /**
     * Sets the value of the cell at the specified row and column.
     * If the cell is not inside the maze, does nothing.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @param value the value to set in the cell
     */
    public void setCell(int row, int col, int value)
    {
        // check if the cell is inside the maze
        // if it is, set the value of the cell
        // if not, do nothing
        if(CheckValidCell(row, col))
        {
            grid[row][col] = value;
        }
    }
    /**
     * Returns the value of the cell at the specified row and column.
     * If the cell is not inside the maze, returns -1.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return the value of the cell, or -1 if the cell is not valid
     */
    public int getCell(int row, int col)
    {
        // check if the cell is inside the maze
        // if it is, return the value of the cell
        // if not, return -1
        if(CheckValidCell(row, col))
        {
            return grid[row][col];
        }
        return -1;
}
    /**
     * Returns the number of rows in the maze.
     *
     * @return the number of rows
     */
    public int getRows()
    {
    return grid.length;
    }
    /**
     * Returns the number of columns in the maze.
     *
     * @return the number of columns
     */
    public int getColumns()
    {
        return grid[0].length;
    }
    /**
     * Returns the start position of the maze.
     *
     * @return the start position
     */
    public Position getStartPosition() {
        return this.start;
    }
    /**
     * Marks the specified position as visited by setting its cell value to 0.
     *
     * @param p the position to mark as visited
     */
public void MarkAsVisited(Position p)
{
    setCell(p.getRowIndex(),p.getColumnIndex(),0);
}
    /**
     * Sets the start position of the maze.
     * The position must be on the edges of the maze.
     *
     * @param S the start position
     */
    public void setStartPosition(Position S) {
        // check if the position is on the edges of the maze
        // if it is, set the start position
        // if not, do nothing
        if(CheckValidEndStartPosition(S))
        {
            this.start = S;
//            this.grid[S.getRowIndex()][S.getColumnIndex()]=2;
        }
    }
    /**
     * Returns the goal position of the maze.
     *
     * @return the goal position
     */
    public Position getGoalPosition() {

        return goal;
    }
    /**
     * Sets the goal position of the maze.
     * The position must be on the edges of the maze.
     *
     * @param G the goal position
     */
    public void setGoalPosition(Position G) {
        // check if the position is on the edges of the maze
        // if it is, set the goal position
        // if not, do nothing
        if(CheckValidEndStartPosition(G))
        {
            this.goal = G;
//            this.grid[G.getRowIndex()][G.getColumnIndex()]=9;
        }
    }

    /**
     * Checks if the specified position is on the edges of the maze.
     *
     * @param p the position to check
     * @return true if the position is valid, false otherwise
     */
    public boolean CheckValidEndStartPosition(Position p)
    {
        // check if the position is on the edges of the maze
        // if it is, return true
        // if not, return false
        if((p.getRowIndex()== grid.length-1 ||p.getRowIndex()==0) && p.getColumnIndex() <= grid[0].length-1 || (p.getColumnIndex() == grid[0].length-1 ||p.getColumnIndex()==0)  &&p.getRowIndex()<= grid.length-1)
            return true;
        return false;
    }
    /**
     * Checks if the specified cell is inside the maze.
     *
     * @param row the row index of the cell
     * @param col the column index of the cell
     * @return true if the cell is valid, false otherwise
     */
    public boolean CheckValidCell(int row, int col)
    {
        // check if the cell is inside the maze
        // if it is, return true
        // if not, return false
        if(row>=0 && row<grid.length && col>=0 && col<grid[0].length)
            return true;
        return false;
    }
    /**
     * Prints the maze to the console.
     * The start position is marked with 'S' and the goal position is marked with 'E'.
     */
    public void print() {
        // print the maze
//        System.out.println("Start: "+ start);
//        System.out.println("Goal: "+ goal);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row == start.getRowIndex() && col == start.getColumnIndex())
                    System.out.print("S ");
                else if (row == goal.getRowIndex() && col == goal.getColumnIndex())
                    System.out.print("E ");
                else {
                    System.out.print(grid[row][col] + " ");
                }

            }
            System.out.println();
        }

        }

    /**
     * Returns the grid of the maze.
     *
     * @return the grid
     */
    public int[][] getGrid() {
        return grid;
    }

    //TODO: Add a toByteArray() function
    //TODO: Add a constructor that accepts a byte array
    //TODO: Add a function that converts an integer to a byte array
    //TODO: Add a function that converts a byte array to an integer

    //Constructor that accepts a byte array

    public Maze(byte[] mazeInBytes) {
        ByteBuffer buffer_a = ByteBuffer.wrap(mazeInBytes, 0, 4);
        ByteBuffer buffer_b = ByteBuffer.wrap(mazeInBytes, 4, 4);
        start = new Position(buffer_a.getInt(),buffer_b.getInt());

        buffer_a = ByteBuffer.wrap(mazeInBytes, 8, 4);
        buffer_b = ByteBuffer.wrap(mazeInBytes, 12, 4);
        goal = new Position(buffer_a.getInt(),buffer_b.getInt());

        buffer_a = ByteBuffer.wrap(mazeInBytes, 16, 4);
        buffer_b = ByteBuffer.wrap(mazeInBytes, 20, 4);
        rows = buffer_a.getInt();
        columns = buffer_b.getInt();

        int index = 24;
        grid = new int[rows][columns];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = mazeInBytes[index++];
            }

        }
    }
    public byte[] toByteArray() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(24+ (rows * columns));
        byteBuffer.putInt(start.getRowIndex());
        byteBuffer.putInt(start.getColumnIndex());
        byteBuffer.putInt(goal.getRowIndex());
        byteBuffer.putInt(goal.getColumnIndex());
        byteBuffer.putInt(rows);
        byteBuffer.putInt(columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                byteBuffer.put((byte)grid[i][j]);
            }
        }

        return byteBuffer.array();
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(start, goal, rows, columns)*31 + Arrays.hashCode(grid);
//    }
    }

