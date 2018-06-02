package by.tweettrends;

import by.tweettrends.constants.Constants;
import by.tweettrends.db.Sentiments;
import by.tweettrends.db.States;
import by.tweettrends.db.Tweets;
import by.tweettrends.entity.MyPolygon;
import by.tweettrends.entity.State;
import by.tweettrends.entity.Tweet;
import javafx.scene.Group;
import javafx.scene.paint.Color;

class Decorator {
    private static double maxSent = 0;
    private static double minSent = 0;

    static void decorate(States states, Tweets tweets, Sentiments sentiments, Group root) {
        findTweetSents(tweets, sentiments);
        findPolygonsSents(states, tweets);
        findSentsBounds(states);

        for (State state :
                states.getStates()) {
            for (MyPolygon polygon :
                    state.getPolygons()) {
                polygon.setFill(getColor(polygon.getSentValue()));
            }
            root.getChildren().addAll(state.getPolygons());
        }

        root.setScaleY(Constants.SCALE);
        root.setScaleX(Constants.SCALE);
        root.setLayoutX(840);
        root.setLayoutY(450);
        root.setRotate(180);
    }

    private static void findSentsBounds(States states) {
        for (State state :
                states.getStates()) {
            for (MyPolygon myPolygon :
                    state.getPolygons()) {
                if (myPolygon.getSentValue() > maxSent)
                    maxSent = myPolygon.getSentValue();
                else if (myPolygon.getSentValue() < minSent)
                    minSent = myPolygon.getSentValue();
            }
        }
    }

    private static void findTweetSents(Tweets tweets, Sentiments sentiments) {
        for (Tweet tweet :
                tweets.getTweetList()) {
            tweet.setTweetSentiment(SentimentCalculator.calculate(tweet.getTweetText(), sentiments));
        }

    }

    private static void findPolygonsSents(States states, Tweets tweets) {
        for (Tweet tweet :
                tweets.getTweetList()) {
            for (State state :
                    states.getStates()) {
                for (MyPolygon polygon :
                        state.getPolygons()) {
                    if (polygon.contains(tweet.getLocation().getLatitude(), tweet.getLocation().getLongitude())) {
                        polygon.setSentValue(polygon.getSentValue() + tweet.getTweetSentiment());
                    }
                }
            }
        }
    }

    private static Color getColor(double sentiment) {
        double red, green, blue;

        if (sentiment < 0) {
            blue = 1;
            green = red = 1 - sentiment / minSent;

        } else if (sentiment > 0) {
            red = 1;
            blue = green = 1 - sentiment / maxSent;
        } else {
            red = 0.5;
            green = 0.5;
            blue = 0.5;
        }
        return new Color(red, green, blue, 1);
    }
}

