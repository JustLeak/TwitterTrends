package by.tweettrends.db;

import by.tweettrends.entity.Tweet;
import java.util.ArrayList;

public class Tweets {
    private ArrayList<Tweet> tweetList;

    public Tweets(ArrayList<Tweet> tweetList) {

        this.tweetList = tweetList;
    }

    public ArrayList<Tweet> getTweetList() {
        return tweetList;
    }
}
