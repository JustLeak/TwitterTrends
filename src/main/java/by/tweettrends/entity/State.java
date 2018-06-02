package by.tweettrends.entity;

import java.util.ArrayList;

public class State {
    private String name;
    private ArrayList<MyPolygon> polygonArrayList;

    public State(String name, ArrayList<MyPolygon> polygonArrayList) {
        this.name = name;
        this.polygonArrayList = polygonArrayList;
    }

    public ArrayList<MyPolygon> getPolygons() {
        return polygonArrayList;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", polygonArrayList=" + polygonArrayList +
                '}';
    }
}
