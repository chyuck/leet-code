package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/alien-dictionary/ problem with
 * Time complexity: O(c)
 * Space complexity: O(1)
 * where c - total number of characters in all words
 */
public class AlienDictionary {

    class InvalidOrderException extends RuntimeException {}

    public String alienOrder(String[] words) {
        try {
            Map<Character, Set<Character>> graph = buildGraph(words);
            Set<Character> chars = getAllChars(words);

            return topologicalSort(chars, graph);
        } catch (InvalidOrderException e) {
            return "";
        }
    }

    private Set<Character> getAllChars(String[] words) {
        Set<Character> results = new HashSet<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                results.add(c);
            }
        }

        return results;
    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> results = new HashMap<>();

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            int minLength = Math.min(word1.length(), word2.length());

            for (int j = 0; j < minLength; j++) {
                Character c1 = word1.charAt(j);
                Character c2 = word2.charAt(j);

                if (c1 != c2) {
                    Set<Character> existingResult = results.get(c1);
                    Set<Character> result = existingResult != null ? existingResult : new HashSet<>();

                    result.add(c2);
                    results.put(c1, result);
                    break;
                } else if (j == minLength - 1 && word1.length() > word2.length()) {
                    throw new InvalidOrderException();
                }
            }
        }

        return results;
    }

    enum VisitStatus { VISITING, VISITED }

    private String topologicalSort(Set<Character> chars, Map<Character, Set<Character>> graph) {
        Stack<Character> results = new Stack<>();
        Map<Character, VisitStatus> visited = new HashMap<>();

        for (Character c : chars) {
            dfp(c, graph, visited, results);
        }

        return convertStackToString(results);
    }

    private void dfp(Character c, Map<Character, Set<Character>> graph, Map<Character, VisitStatus> visited,
        Stack<Character> results) {

        VisitStatus status = visited.get(c);
        if (status == null) {
            visited.put(c, VisitStatus.VISITING);
        } else if (status == VisitStatus.VISITED) {
            return;
        } else {
            throw new InvalidOrderException();
        }

        Set<Character> children = graph.get(c);
        if (children != null) {
            for (Character child : children) {
                dfp(child, graph, visited, results);
            }
        }

        results.push(c);
        visited.put(c, VisitStatus.VISITED);
    }

    private String convertStackToString(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();

        while (!stack.empty()) {
            Character c = stack.pop();
            result.append(c);
        }

        return result.toString();
    }
}
