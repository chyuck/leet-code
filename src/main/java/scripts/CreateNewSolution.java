package scripts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;

public class CreateNewSolution {

    public static void main(String[] args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("Arguments: number, url");
        }

        createSolution(args[0], args[1]);

        System.out.println("Solution files created");
    }

    private static void createSolution(String number, String url) {
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

        Matcher matcher = URL_PATTERN.matcher(url);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid LeetCode URL.")    ;
        }

        String urlNamePart = matcher.group(1);
        String[] nameParts = urlNamePart.split("-");

        StringBuilder sb = new StringBuilder();

        for (String namePart : nameParts) {
            sb.append(Character.toUpperCase(namePart.charAt(0)));
            sb.append(namePart.substring(1));
        }

        return sb.toString();
    }

    private static void createSolutionFile(String name, String url) {

    }

    private static void createTestsFile(String name) {

    }

    private static void updateReadmeFile(String number, String url, String name) {

    }
}
