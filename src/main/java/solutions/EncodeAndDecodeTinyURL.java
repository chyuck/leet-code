package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/encode-and-decode-tinyurl problem with
 * Space complexity: O(n)
 * where n - number of unique encoded URL
 */
public class EncodeAndDecodeTinyURL {

    // hash maps for storing short URL mapping with long URL
    private final Map<String, String> shortToLong = new HashMap<>();
    private final Map<String, String> longToShort = new HashMap<>();
    // unique id counter
    private int counter = 0;

    // base URL for short URL
    private final String baseUrl = "http://tinyurl.com/";

    /**
     * Time complexity: O(1), because it proportional to length of encoded URL, which is 6
     */
    public String encode(String longUrl) {
        // if URL is already encoded, just return short URL
        if (longToShort.containsKey(longUrl))
            return longToShort.get(longUrl);

        // increment counter and convert it to base62 number
        String base62 = convertDecimalToBase62(++counter);
        // create short URL by adding base62 number to base URL
        String shortUrl = baseUrl + base62;

        // add mappings to has maps
        shortToLong.put(shortUrl, longUrl);
        longToShort.put(longUrl, shortUrl);

        // return short URL
        return shortUrl;
    }

    // all possible characters in base62
    private final String base62Chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private String convertDecimalToBase62(int decimal) {
        StringBuilder builder = new StringBuilder();

        // standard algorithm to convert decimal to another base encoding
        while (decimal > 0) {
            char base62Char = base62Chars.charAt(decimal % base62Chars.length());
            builder.insert(0, base62Char);
            decimal /= base62Chars.length();
        }

        // if base62 number has length less than 6, add leading zero characters
        while (builder.length() < 6) {
            builder.insert(0, base62Chars.charAt(0));
        }

        return builder.toString();
    }

    /**
     * Time complexity: O(1)
     */
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}
