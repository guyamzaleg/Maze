package algorithms.search;

import algorithms.mazeGenerators.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class BestFirstSearchTest {


    @Test
    void testBestFirstSearch() {
        // Create a maze using SimpleMazeGenerator
        IMazeGenerator mazeGenerator = new SimpleMazeGenerator();
        Maze maze = mazeGenerator.generate(50, 50);

        // Initialize the search algorithm
        BestFirstSearch bestFirstSearch = new BestFirstSearch();

        // Solve the maze
        Solution solution = bestFirstSearch.solve(new SearchableMaze(maze));

        // Check if the solution is correct
        assertNotNull(solution, "Solution should not be null");

        // Validate the solution path
        ArrayList<AState> path = solution.getSolutionPath();
        assertFalse(path.isEmpty(), "Solution path should not be empty");

        // Ensure the solution starts at the maze's start position
        assertEquals(maze.getStartPosition().toString(),path.get(0).toString(), "Solution should start at the maze's start position");

        // Ensure the solution ends at the maze's goal position
        assertEquals(maze.getGoalPosition().toString(), path.get(path.size() - 1).toString(), "Solution should end at the maze's goal position");
    }

    @Test
    void testBestFirstSearchWithNullSearchable() {
        // Initialize the search algorithm
        BestFirstSearch bestFirstSearch = new BestFirstSearch();

        // Solve the maze with null searchable
        Solution solution = bestFirstSearch.solve(null);

        // Check if the solution is null
        assertNull(solution, "Solution should be null for null searchable");
    }

    @Test
    void testBestFirstSearchWithSimpleMaze() {
        // Create a simple maze with specific start and goal positions
        Position startPosition = new Position(0, 0);
        Position goalPosition = new Position(4, 4);
        Maze maze = new Maze(5, 5);
        maze.setStartPosition(startPosition);
        maze.setGoalPosition(goalPosition);

        // Initialize the search algorithm
        BestFirstSearch bestFirstSearch = new BestFirstSearch();

        // Solve the maze
        Solution solution = bestFirstSearch.solve(new SearchableMaze(maze));

        // Check if the solution is correct
        assertNotNull(solution, "Solution should not be null");

        // Validate the solution path
        ArrayList<AState> path = solution.getSolutionPath();
        assertFalse(path.isEmpty(), "Solution path should not be empty");

        // Ensure the solution starts at the maze's start position
        assertEquals(startPosition.toString(), path.get(0).toString(), "Solution should start at the maze's start position");

        // Ensure the solution ends at the maze's goal position
        assertEquals(goalPosition.toString(), path.get(path.size() - 1).toString(), "Solution should end at the maze's goal position");
    }




}
