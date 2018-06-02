package by.tweettrends.entity;

public class Tweet {
    private Location location;
    private String tweetText;
    private double tweetSentiment;

    public Tweet(Location location, String tweetText) {
        this.location = location;
        this.tweetText = tweetText;
        this.tweetSentiment = 0;

    }

    public String getTweetText() {
        return tweetText;
    }

    public double getTweetSentiment() {
        return tweetSentiment;
    }

    public void setTweetSentiment(double tweetSentiment) {
        this.tweetSentiment = tweetSentiment;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "location=" + location +
                ", tweetText='" + tweetText + '\'' +
                ", tweetSentiment=" + tweetSentiment +
                '}';
    }
}
