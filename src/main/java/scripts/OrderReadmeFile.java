package scripts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

public class OrderReadmeFile {

    public static void main(String[] args) {
        try {
            order();
            System.out.println("File ordered");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String lineSeparator = System.getProperty("line.separator");

    private static void order() throws IOException {
        var path = Paths.get("README.md");

        var lines = Files.readAllLines(path);
        if (lines.size() == 0)
            return;

        var iterator = lines.iterator();
        var sb = new StringBuilder();

        while (iterator.hasNext()) {
            var line = iterator.next();
            sb.append(line);
            sb.append(lineSeparator);

            if (line.indexOf("| --- |") != -1)
                break;
        }

        var sortedMap = new TreeMap<Integer, String>();

        while (iterator.hasNext()) {
            var line = iterator.next();
            if (line.isBlank())
                continue;

            int number = 0;
            for (int i = 1; i < line.length(); i++) {
                var ch = line.charAt(i);
                if ('0' <= ch && ch <= '9') {
                    var digit = ch - '0';
                    number = number * 10 + digit;
                    continue;
                }

                if (ch == ' ')
                    continue;

                break;
            }

            if (number > 0) {
                sortedMap.put(number, line);
            }
        }

        for (var value : sortedMap.values()) {
            sb.append(value);
            sb.append(lineSeparator);
        }

        var bytes = sb.toString().getBytes();
        Files.write(path, bytes);
    }
}