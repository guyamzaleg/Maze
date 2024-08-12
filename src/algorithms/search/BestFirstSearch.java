package algorithms.search;

import java.util.PriorityQueue;
/**
 * The BestFirstSearch class extends the BreadthFirstSearch class.
 * This class implements the Best-First Search algorithm, which prioritizes states with lower costs.
 */
public class BestFirstSearch extends  BreadthFirstSearch{
    /**
     * Constructs a BestFirstSearch object.
     * Initializes the queue as a priority queue with a comparator that compares the cost of the states.
     */
public BestFirstSearch()
{
    super();
    //Defining the queue as a priority queue with a comparator that compares the cost of the states
    queue = new PriorityQueue<AState>((a,b) -> (int)(a.getCost() - b.getCost()));
}
    /**
     * Solves the given searchable problem using the Best-First Search algorithm.
     * This method overrides the solve method in the BreadthFirstSearch class.
     *
     * @param searchable the problem to be solved
     * @return a Solution object representing the solution to the problem
     */
    @Override
    public Solution solve(ISearchable searchable)
    {
        return super.solve(searchable);
    }
    /**
     * Returns the name of the search algorithm.
     *
     * @return the name of the search algorithm
     */
    @Override
    public String getName() {
        return "Best First Search";
    }
}
