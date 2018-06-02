package by.tweettrends.db;

import by.tweettrends.entity.State;
import java.util.ArrayList;

public class States {
    private ArrayList<State> statesList;

    public States(ArrayList<State> statesList) {
        this.statesList = statesList;
    }

    public ArrayList<State> getStates() {
        return statesList;
    }
}
