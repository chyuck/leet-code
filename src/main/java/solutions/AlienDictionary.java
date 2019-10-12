package solutions;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        HashSet<Character> chars = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!chars.contains(c))
                    chars.add(c);
            }
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            int length = Math.min(words[i].length(), words[i+1].length());

            for (int j = 0; j < length; j++) {
                char c1 = words[i].charAt(j);
                char c2 = words[i+1].charAt(j);

                if (c1 == c2) continue;

                Set<Character> list = graph.get(c1);
                if (list == null) list = new HashSet<Character>();
                if (!list.contains(c2)) list.add(c2);
                graph.put(c1, list);
                break;
            }
        }

        Map<Character, Status> visitStatus = new HashMap<>(chars.size());
        Stack<Character> results = new Stack<>();

        try {
            for (Character c : chars) {
                dfs(graph, visitStatus, results, c);
            }
        } catch (InvalidOrderException e) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while (results.size() > 0) {
            sb.append(results.pop());
        }

        return sb.toString();
    }

    enum Status { VISITING, VISITED; }

    class InvalidOrderException extends Exception {};

    private void dfs(Map<Character, Set<Character>> graph, Map<Character, Status> visitStatus, Stack<Character> results, Character curr)
            throws InvalidOrderException, UnsupportedOperationException {
        if (visitStatus.containsKey(curr)) {
            Status status = visitStatus.get(curr);
            switch (status) {
                case VISITING:
                    throw new InvalidOrderException();
                case VISITED:
                    return;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        visitStatus.put(curr, Status.VISITING);

        Set<Character> children = graph.get(curr);
        if (children != null) {
            for (Character child: children) {
                dfs(graph, visitStatus, results, child);
            }
        }

        visitStatus.put(curr, Status.VISITED);

        results.add(curr);
    }
}
