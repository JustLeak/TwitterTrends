package by.tweettrends.parsers;

import by.tweettrends.entity.MyPolygon;
import by.tweettrends.entity.State;

import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StatesParser {
    private ArrayList<State> stateList = new ArrayList<>();

    public ArrayList<State> parse(String toParse) {
        String regularState = "\"[A-Z]{2}\"[^\"]*";
        Pattern pattern = Pattern.compile(regularState);
        Matcher matcher = pattern.matcher(toParse);

        ArrayList<MatchResult> arrayList = matcher.results().collect(Collectors.toCollection(ArrayList::new));
        for (MatchResult match :
                arrayList) {
            stateList.add(new State(parseStateName(match.group()), parsePolygons(match.group())));
        }

        return stateList;
    }

    private String parseStateName(String stateStr) {
        String regularStateName = "[A-Z]{2}";
        Pattern pattern = Pattern.compile(regularStateName);
        Matcher matcher = pattern.matcher(stateStr);
        matcher.find();
        return matcher.group();
    }

    private ArrayList<MyPolygon> parsePolygons(String stateStr) {
        String regularPolygon = "[\\[]{2}[^\\[].*?\\]{2}";
        Pattern pattern = Pattern.compile(regularPolygon);
        Matcher matcher = pattern.matcher(stateStr);

        ArrayList<MyPolygon> polygons = new ArrayList<>();
        MyPolygon polygon;
        ArrayList<Double> doubles;

        ArrayList<MatchResult> arrayList = matcher.results().collect(Collectors.toCollection(ArrayList::new));
        for (MatchResult match :
                arrayList) {
            doubles = parseDoubles(match.group());
            polygon = new MyPolygon();
            polygon.getPoints().addAll(doubles);
            polygons.add(polygon);
        }

        return polygons;
    }

    private ArrayList<Double> parseDoubles(String polygonStr) {
        ArrayList<Double> doubles = new ArrayList<>();
        String regularDouble = "\\d+.\\d+";
        Pattern pattern = Pattern.compile(regularDouble);
        Matcher matcher = pattern.matcher(polygonStr);

        ArrayList<MatchResult> arrayList = matcher.results().collect(Collectors.toCollection(ArrayList::new));
        for (MatchResult match :
                arrayList) {
            doubles.add(Double.valueOf(match.group()));
        }
        return doubles;
    }
}
