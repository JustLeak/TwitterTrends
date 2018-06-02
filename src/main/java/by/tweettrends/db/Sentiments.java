package by.tweettrends.db;

import java.util.HashMap;

public class Sentiments {
    private HashMap<String, Double> dictionary;

    public HashMap<String, Double> getDictionary() {
        return dictionary;
    }

    public Sentiments(HashMap<String, Double> stringDoubleHashMap) {
        this.dictionary = stringDoubleHashMap;
    }
}
