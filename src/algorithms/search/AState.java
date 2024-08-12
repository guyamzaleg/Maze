package algorithms.search;

import java.io.Serializable;

/**
 * The AState class represents a state in a search algorithm.
 * It provides common properties and methods for managing the state, such as cost, parent state, and visitation status.
 */
public  abstract class AState implements Serializable {
    private int cost;
    private AState parent;  // Renamed for clarity

    private boolean is_visited;
    /**
     * Constructs an AState object with default values.
     * The visitation status is initially set to false.
     */
    public AState()
    {
        this.is_visited = false;
    }
    /**
     * Returns the cost associated with this state.
     *
     * @return the cost of the state
     */

    public int getCost() {
        return cost;
    }
    /**
     * Sets the cost associated with this state.
     *
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Returns the parent state of this state.
     *
     * @return the parent state
     */
    public AState getParent() {
        return parent;
    }

    /**
     * Marks this state as visited.
     */
    public void SetVisit(){
        is_visited = true;
    }

    /**
     * Returns whether this state has been visited.
     *
     * @return true if the state has been visited, false otherwise
     */
    public void setParent(AState parent) {
        this.parent = parent;
    }

    public boolean Is_visited() {
        return is_visited;
    }
    /**
     * Resets the state, clearing the parent and marking it as not visited.
     */
    public void restartState() {
        parent = null;
        is_visited = false;
    }


    // Override equals and hashCode if necessary, based on specific use case
}
