package by.tweettrends;

import by.tweettrends.db.Sentiments;

class SentimentCalculator {
    static double calculate(String text, Sentiments sentiments) {
        double value = 0;

        for (String key :
                sentiments.getDictionary().keySet()) {
            if (text.contains(key)) {
                value += sentiments.getDictionary().get(key);
            }
        }
        return value;
    }
}
