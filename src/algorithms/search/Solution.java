package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Solution implements Serializable {

    private ArrayList<AState> path;

    public Solution() {
        this.path = new ArrayList<>();  // Initialize the path list
    }
    public void add_State(AState part_solution){
        if(part_solution==null)return;
        path.add(part_solution);
    }


    public ArrayList<AState> getSolutionPath() {
        return new ArrayList<>(path);  // Return a copy of the path to avoid external modifications
    }

    public void reverse() {
        Collections.reverse(path);  // Reverse the order of the path list
    }


}
