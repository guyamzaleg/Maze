package test;

import algorithms.mazeGenerators.*;
import algorithms.search.*;

import java.util.ArrayList;

public class RunSearchOnMaze {
    public static void main(String[] args) {



            IMazeGenerator mg = new MyMazeGenerator();
            Maze maze = mg.generate(20, 50);
            SearchableMaze searchableMaze = new SearchableMaze(maze);
            searchableMaze.getMaze().print();
            solveProblem(searchableMaze, new BreadthFirstSearch());
            solveProblem(searchableMaze, new DepthFirstSearch());
            solveProblem(searchableMaze, new BestFirstSearch());
        }



    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {
        // Solve a searching problem with a searcher
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s",
                searcher.getName(), searcher.getNumberOfNodesEvaluated()));
        // Printing Solution Path
        System.out.println("the start="+domain.getStartState());
        System.out.println("the goal="+domain.getGoalState());
        System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i <solutionPath.size() ; i++)
        {
            System.out.println(String.format("%d. %s", i, solutionPath.get(i)));
        }
    }
}
