package by.tweettrends.entity;

import javafx.scene.shape.Polygon;

public class MyPolygon extends Polygon {
    private double sentValue;

    public MyPolygon(double... points) {

        super(points);
        this.sentValue = 0;
    }

    public double getSentValue() {
        return sentValue;
    }

    public void setSentValue(double sentValue) {
        this.sentValue = sentValue;
    }

    @Override
    public String toString() {
        return "MyPolygon{" +
                "sentValue=" + sentValue +
                '}';
    }
}
