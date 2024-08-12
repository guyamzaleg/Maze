package algorithms.mazeGenerators;
/**
 * The EmptyMazeGenerator class extends the AMazeGenerator class.
 * This class provides an implementation of the generate method that creates an empty maze.
 */
public class EmptyMazeGenerator extends AMazeGenerator {



    /**
     * Generates an empty maze with the specified number of rows and columns.
     * This method returns a simple Maze object with no walls or obstacles.
     *
     * @param rows the number of rows in the maze
     * @param columns the number of columns in the maze
     * @return a Maze object representing an empty maze
     */
    public Maze generate(int rows, int columns)
    {
         Maze maze_simple = new Maze(rows, columns);

        return maze_simple;
    }
}
