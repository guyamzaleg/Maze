package algorithms.search;

import java.util.ArrayList;
import java.util.List;
/**
 * The ISearchable interface defines the methods that any searchable problem must implement.
 * These methods include getting the start and goal states, getting all possible states from a given state,
 * and restarting the maze or search problem.
 */
public interface ISearchable {
    /**
     * Returns the start state of the searchable problem.
     *
     * @return the start state
     */
    AState getStartState();

    /**
     * Returns the goal state of the searchable problem.
     *
     * @return the goal state
     */
    AState getGoalState();

    /**
     * Returns a list of all possible states that can be reached from the given state.
     *
     * @param s the current state
     * @return a list of all possible states from the given state
     */
    List<AState> getAllPossibleStates(AState s);
    /**
     * Restarts the maze or search problem to its initial state.
     */
    public void restartMaze();
}
