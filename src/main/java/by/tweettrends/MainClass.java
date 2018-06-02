package by.tweettrends;

import by.tweettrends.constants.Constants;
import by.tweettrends.db.Sentiments;
import by.tweettrends.db.States;
import by.tweettrends.db.Tweets;
import by.tweettrends.parsers.SentimentsParser;
import by.tweettrends.parsers.StatesParser;
import by.tweettrends.parsers.TweetsParser;
import by.tweettrends.readers.FileReader;
import by.tweettrends.readers.IReader;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClass extends Application {
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        IReader reader = new FileReader(Constants.SENTIMENTS_PATH);
        SentimentsParser sentimentsParser = new SentimentsParser();
        Sentiments sentiments = new Sentiments(sentimentsParser.parse(reader.read()));

        reader = new FileReader(Constants.STATES_PATH);
        StatesParser statesParser = new StatesParser();
        States states = new States(statesParser.parse(reader.read()));

        reader = new FileReader(Constants.SANDWICH_PATH);
        TweetsParser tweetsParser = new TweetsParser();
        Tweets tweets = new Tweets(tweetsParser.parse(reader.read()));

        reader = new FileReader(Constants.MY_JOB_PATH);
        tweetsParser = new TweetsParser();
        tweets.getTweetList().addAll(tweetsParser.parse(reader.read()));

        Group root = new Group();
        Decorator.decorate(states, tweets, sentiments, root);

        Scene scene = new Scene(root, 1920, 1040);
        stage.setScene(scene);
        stage.show();
    }
}
