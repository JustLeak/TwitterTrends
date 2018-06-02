package by.tweettrends.parsers;

import by.tweettrends.entity.Location;
import by.tweettrends.entity.Tweet;
import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TweetsParser {
    private final ArrayList<Tweet> tweetList = new ArrayList<>();

    public ArrayList<Tweet> parse(String toParse) {
        String regularTweet = "[^\\n]+";
        Pattern pattern = Pattern.compile(regularTweet);
        Matcher matcher = pattern.matcher(toParse);

        ArrayList<MatchResult> arrayList = matcher.results().collect(Collectors.toCollection(ArrayList::new));
        for (MatchResult match :
                arrayList) {
            match.group();
            tweetList.add(new Tweet(parseLocation(match.group()), parseTweetText(match.group())));
        }

        return tweetList;
    }

    private Location parseLocation(String tweetStr) {
        String regularLocation = "\\[\\d+.\\d+, -\\d+.\\d+]";
        Pattern pattern = Pattern.compile(regularLocation);
        Matcher matcher = pattern.matcher(tweetStr);
        matcher.find();
        String locationStr = matcher.group();

        String regularDouble = "\\d+.\\d+";
        pattern = Pattern.compile(regularDouble);
        matcher = pattern.matcher(locationStr);

        matcher.find();
        double longitude = Double.parseDouble(matcher.group());
        matcher.find(matcher.group().length());
        double latitude = Double.parseDouble(matcher.group());

        return new Location(longitude, latitude);
    }

    private String parseTweetText(String tweetStr) {
        String regularText = "\\t.+";
        Pattern pattern = Pattern.compile(regularText);
        Matcher matcher = pattern.matcher(tweetStr);

        matcher.find();
        StringBuilder stringBuilder = new StringBuilder(matcher.group());
        stringBuilder.delete(0, 23);
        return stringBuilder.toString();
    }
}
