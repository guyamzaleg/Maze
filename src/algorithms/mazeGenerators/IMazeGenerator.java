package algorithms.mazeGenerators;
/**
 * The IMazeGenerator interface defines the methods that any maze generator class must implement.
 * It includes methods for generating a maze and measuring the time taken to generate a maze.
 */
public interface IMazeGenerator {
     /**
      * Generates a maze with the specified number of rows and columns.
      * The implementation of this method should create and return a Maze object.
      *
      * @param rows the number of rows in the maze
      * @param columns the number of columns in the maze
      * @return a Maze object representing the generated maze
      */
     Maze generate(int rows,int columns);

     /**
      * Measures the time taken to generate a maze with the specified number of rows and columns.
      * This method records the start time, invokes the generate method, and then records the end time.
      * The difference between the end time and the start time is returned as the time taken to generate the maze.
      *
      * @param rows the number of rows in the maze
      * @param columns the number of columns in the maze
      * @return the time taken to generate the maze in milliseconds
      */
     long measureAlgorithmTimeMillis(int rows,int columns) ;



}
