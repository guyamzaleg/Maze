package algorithms.search;
/**
 * The ISearchingAlgorithm interface defines the methods that any search algorithm must implement.
 * These methods include solving a searchable problem, getting the name of the algorithm,
 * and getting the number of nodes evaluated during the search.
 */
public interface ISearchingAlgorithm {

    /**
     * Solves the given searchable problem using the specific search algorithm.
     *
     * @param searchable the problem to be solved
     * @return a Solution object representing the solution to the problem
     */
    Solution solve(ISearchable searchable);
    /**
     * Returns the name of the search algorithm.
     *
     * @return the name of the search algorithm
     */
    String getName();

    /**
     * Returns the number of nodes evaluated by the search algorithm.
     *
     * @return the number of nodes evaluated
     */
    int getNumberOfNodesEvaluated();
}
