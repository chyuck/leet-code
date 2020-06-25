package scripts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

final class ReadmeFileUtils {
    private ReadmeFileUtils() {}

    public static String createLine(int number, String url, String name) {
        Preconditions.checkArgument(number > 0);
        Preconditions.checkArgument(StringUtils.isNotBlank(url));
        Preconditions.checkArgument(StringUtils.isNotBlank(name));

        var title = createTitle(name);

        return String.format(
            "| %s | ? | [%s](%s) | [%s.java](src/main/java/solutions/%s.java) ([Tests](src/test/java/solutions/%sTests.java)) |",
            number, title, url, name, name, name);
    }

    private static String createTitle(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name));

        var sb = new StringBuilder();

        var chars = name.toCharArray();
        sb.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            var c = chars[i];

            if (Character.isUpperCase(c)) {
                sb.append(" ");
            }

            sb.append(c);
        }

        return sb.toString();
    }

    public static void addLineAndOrderReadmeFile(int newLineNumber, String newLine) throws IOException {
        var path = Paths.get("README.md");

        var lines = Files.readAllLines(path);
        if (lines.size() == 0)
            return;

        var iterator = lines.iterator();
        var sb = new StringBuilder();

        while (iterator.hasNext()) {
            var line = iterator.next();
            sb.append(line);
            sb.append(System.lineSeparator());

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

        if (newLineNumber > 0 && StringUtils.isNotBlank(newLine)) {
            sortedMap.put(newLineNumber, newLine);
        }

        for (var value : sortedMap.values()) {
            sb.append(value);
            sb.append(System.lineSeparator());
        }

        var bytes = sb.toString().getBytes();
        Files.write(path, bytes);
    }
}
