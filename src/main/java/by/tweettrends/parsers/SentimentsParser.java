package by.tweettrends.parsers;

import java.util.HashMap;

public class SentimentsParser {
    public HashMap<String, Double> parse(String toParse) {
        HashMap<String, Double> dictionary = new HashMap<>();

        String[] subStrings = toParse.split("\n");
        for (String subStr : subStrings) {
            String[] sentimentInStr = subStr.split(",");
            dictionary.put(sentimentInStr[0], Double.parseDouble(sentimentInStr[1]));
        }
        return dictionary;
    }
}
