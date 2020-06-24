package scripts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

public class CreateNewSolution {

    public static void main(String[] args) {
        try {
            if (args == null || args.length != 2) {
                throw new IllegalArgumentException("Arguments: number, url");
            }

            createSolution(args[0], args[1]);

            System.out.println("Solution files created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createSolution(String number, String url) throws IOException {
        Preconditions.checkArgument(StringUtils.isNotBlank(number));
        Preconditions.checkArgument(StringUtils.isNotBlank(url));

        String name = createName(url);

        createSolutionFile(name, url);
        createTestsFile(name);
        updateReadmeFile(number, url, name);
    }

    private static final Pattern URL_PATTERN =
            Pattern.compile("^https:\\/\\/leetcode\\.com\\/problems\\/([a-z0-9-]+)\\/$");

    static String createName(String url) {
        Preconditions.checkArgument(StringUtils.isNotBlank(url));

        var matcher = URL_PATTERN.matcher(url);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid LeetCode URL.")    ;
        }

        var urlNamePart = matcher.group(1);
        var nameParts = urlNamePart.split("-");

        var sb = new StringBuilder();

        for (var namePart : nameParts) {
            sb.append(Character.toUpperCase(namePart.charAt(0)));
            sb.append(namePart.substring(1));
        }

        return sb.toString();
    }

    private static void createSolutionFile(String name, String url) throws IOException {
        Preconditions.checkArgument(StringUtils.isNotBlank(name));
        Preconditions.checkArgument(StringUtils.isNotBlank(url));

        var sb = new StringBuilder();

        appendLine(sb, "package solutions;");
        appendLine(sb, StringUtils.EMPTY);
        appendLine(sb, "/**");
        appendLine(sb, " * Solution for " + url +" problem with");
        appendLine(sb, " * Time complexity: O(?)");
        appendLine(sb, " * Space complexity: O(?)");
        appendLine(sb, " */");
        appendLine(sb, "public class " + name + " {");
        appendLine(sb, StringUtils.EMPTY);
        appendLine(sb, "}");

        var bytes = sb.toString().getBytes();
        var path = Paths.get("src", "main", "java", "solutions", name + ".java");
        Files.write(path, bytes);
    }

    private static void appendLine(StringBuilder sb, String line) {
        Preconditions.checkNotNull(sb);
        Preconditions.checkNotNull(line);

        sb.append(line).append(System.lineSeparator());
    }

    private static void createTestsFile(String name) {

    }

    private static void updateReadmeFile(String number, String url, String name) {

    }
}
