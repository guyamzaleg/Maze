package algorithms.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * The DepthFirstSearch class extends the ASearchingAlgorithm class.
 * This class implements the Depth-First Search (DFS) algorithm.
 */
public class DepthFirstSearch extends  ASearchingAlgorithm
{
    /**
     * Solves the given searchable problem using the Depth-First Search algorithm.
     *
     * @param searchable the problem to be solved
     * @return a Solution object representing the solution to the problem, or null if no solution is found
     */
    @Override
    public Solution solve(ISearchable searchable)
    {
        if (searchable == null) return new Solution();
        Stack<AState> stack = new Stack<AState>();
        stack.push(searchable.getStartState());
        while(!stack.isEmpty())
        {
            this.numberOfNodesEvaluated++;
           AState currentState = stack.pop();
           currentState.SetVisit();
           if(currentState.equals(searchable.getGoalState()))
           {
               Solution solution = reconstructPath(currentState);
//               this.setNumberOfNodesEvaluated(solution.getPath().size()-1);
               solution.reverse();//______________________________________________________________________________________ i add
               searchable.restartMaze();
               return solution;
           }
            List<AState> neighbors = searchable.getAllPossibleStates(currentState);
           if(neighbors != null) {
               for (AState neighbor : neighbors) {
                   if (!neighbor.Is_visited()) {
                       neighbor.setParent(currentState);
//                       this.numberOfNodesEvaluated++;
                       stack.push(neighbor);
                       neighbor.SetVisit();
                   }
               }
           }
        }
        searchable.restartMaze();
        return null;
    }

    /**
     * Returns the name of the search algorithm.
     *
     * @return the name of the search algorithm
     */
    @Override
    public String getName() {
        return "Depth First Search";
    }
}
