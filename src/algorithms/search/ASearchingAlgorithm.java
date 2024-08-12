package algorithms.search;

import java.util.Collections;
/**
 * The ASearchingAlgorithm class provides a base implementation for search algorithms.
 * This abstract class implements the ISearchingAlgorithm interface and provides common functionality
 * for search algorithms, such as tracking the number of nodes evaluated and reconstructing the path from the goal state.
 */
public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int numberOfNodesEvaluated = 0;
    /**
     * Returns the number of nodes evaluated by the search algorithm.
     *
     * @return the number of nodes evaluated
     */

    @Override
        public int getNumberOfNodesEvaluated() {
            return numberOfNodesEvaluated;
    }
    /**
     * Sets the number of nodes evaluated by the search algorithm.
     *
     * @param numberOfNodesEvaluated the number of nodes evaluated
     */
    public void setNumberOfNodesEvaluated(int numberOfNodesEvaluated) {
        this.numberOfNodesEvaluated = numberOfNodesEvaluated;
    }
    /**
     * Reconstructs the path from the goal state to the initial state.
     * The path is built by traversing the parent links from the goal state to the initial state,
     * and then reversing the path to start from the initial state.
     *
     * @param goalState the goal state
     * @return a Solution object representing the path from the initial state to the goal state
     */
    static Solution reconstructPath(AState goalState)
    {
        Solution solution = new Solution();
        AState current = goalState;
        while (current != null)
        {
            solution.add_State(current);
            current = current.getParent();
        }
        Collections.reverse(solution.getSolutionPath());  // Reverse the path to start from the initial state
        return solution;
    }
}
