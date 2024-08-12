package test;

import algorithms.mazeGenerators.*;

public class RunMazeGenerator {
    public static void main(String[] args)
    {
//            testMazeGenerator(new EmptyMazeGenerator());
//            testMazeGenerator(new SimpleMazeGenerator());
            testMazeGenerator(new MyMazeGenerator());
    }
    public static void testMazeGenerator(IMazeGenerator mazeGenerator)
    {
        try
        {
            // prints the time it takes the algorithm to run
            System.out.println(String.format("Maze generation time(ms): %s", mazeGenerator.measureAlgorithmTimeMillis(100/*rows*/,100/*columns*/)));
            // generate another maze
            Maze maze = mazeGenerator.generate(15/*rows*/, 15/*columns*/);
            // prints the maze
            maze.print();
            // get the maze entrance
            Position startPosition = maze.getStartPosition();
            // print the entrance
            System.out.println(String.format("Start Position: %s", startPosition)); // format "{row,column}"
            // get the maze exit
            Position goalPosition = maze.getGoalPosition();
            // print the exit
            System.out.println(String.format("Goal Position: %s", goalPosition)); // format "{row,column}"
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }
}