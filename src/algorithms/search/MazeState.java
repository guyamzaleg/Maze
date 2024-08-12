package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    /**
     * The MazeState class extends the AState class.
     * This class represents a state in a maze, defined by its current position.
     */
   private Position current;
    /**
     * Constructs a MazeState object with the specified position.
     *
     * @param my_position the position of the state
     */
    public MazeState(Position my_position) {
        current=my_position;
    }
    /**
     * Compares this state to another object for equality.
     * Two MazeState objects are considered equal if they have the same row and column indices.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MazeState mazeState = (MazeState) obj;
        return current.getRowIndex() == mazeState.current.getRowIndex() &&
                current.getColumnIndex() == mazeState.current.getColumnIndex();
    }
    /**
     * Returns the current position of the state.
     *
     * @return the current position
     */
    public Position getCurrent() {
        return current;
    }
    /**
     * Sets the current position of the state.
     *
     * @param current the position to set
     */
    public void setCurrent(Position current) {
        this.current = current;
    }

    /**
     * Returns a string representation of the MazeState.
     * The string is formatted as "{column,row}".
     *
     * @return a string representation of the MazeState
     */
    @Override
    public String toString() {
        return
                "{" + current.getColumnIndex() + "," + current.getRowIndex() +"}";

    }
}
