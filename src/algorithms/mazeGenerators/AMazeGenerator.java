package algorithms.mazeGenerators;
/**
 * Abstract class AMazeGenerator implements the IMazeGenerator interface.
 * This class provides a common implementation for maze generation algorithms.
 */
public abstract  class  AMazeGenerator  implements IMazeGenerator {



    /**
     * Measures the time taken to generate a maze with the specified number of rows and columns.
     * This method records the start time, invokes the generate method, and then records the end time.
     * The difference between the end time and the start time is returned as the time taken to generate the maze.
     *
     * @param rows the number of rows in the maze
     * @param columns the number of columns in the maze
     * @return the time taken to generate the maze in milliseconds
     */
    @Override
    public long measureAlgorithmTimeMillis(int rows, int columns)
    {
        long startTime = System.currentTimeMillis();
        generate(rows, columns);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

}
