package algorithms.mazeGenerators;

import java.io.Serializable;

/**
 * The Position class represents a position in a maze, defined by its row and column indices.
 */
public class Position implements Serializable {
    private int row;
    private int column;
    /**
     * Constructs a Position object with the specified row and column indices.
     *
     * @param row the row index of the position
     * @param column the column index of the position
     */
    public Position(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
    /**
     * Returns the row index of the position.
     *
     * @return the row index
     */
    public int getRowIndex() {
        return row;
    }
    /**
     * Returns the column index of the position.
     *
     * @return the column index
     */
    public int getColumnIndex() {
        return column;
    }
    /**
     * Compares this position to another position for equality.
     *
     * @param p the position to compare with
     * @return true if the positions are equal, false otherwise
     */
       public boolean equals(Position p) {
        return (this.row == p.getRowIndex() && this.column == p.getColumnIndex());
    }
    /**
     * Checks if this position has the same row and column indices as the specified row and column.
     *
     * @param row the row index to compare
     * @param column the column index to compare
     * @return true if the position matches the specified row and column, false otherwise
     */
    public boolean SameAsOther(int row, int column) {
        return (this.row == row && this.column == column);
    }
    /**
     * Returns a string representation of the position.
     * The string is formatted as "{column,row}".
     *
     * @return a string representation of the position
     */
    @Override
    public String toString() {
        return "{" + column + "," + row + "}";
    }
}