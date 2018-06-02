package by.tweettrends.readers;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader implements IReader {
    private final String pathname;

    public FileReader(final String filename) {
        this.pathname = filename;
    }

    @Override
    public String read() throws IOException {
        StringBuilder builder = new StringBuilder();
        java.io.FileReader fR = new java.io.FileReader(new File(pathname));

        Scanner scan = new Scanner(fR);

        while (scan.hasNextLine()) {
            builder.append(scan.nextLine()).append('\n');
        }

        scan.close();
        fR.close();
        return builder.toString();
    }
}
