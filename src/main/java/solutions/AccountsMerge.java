package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/accounts-merge/ problem with
 * Time complexity: O(SUM(Ai * log(Ai)))
 * Space complexity: O(SUM(Ai))
 * where Ai - length of account with index i
 */
public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> emailGraph = buildEmailGraph(accounts);
        Map<String, String> emailsToNamesMap = buildEmailsToNamesMap(accounts);

        return mergeAccounts(emailGraph, emailsToNamesMap);
    }

    private static Map<String, Set<String>> buildEmailGraph(List<List<String>> accounts) {
        Map<String, Set<String>> results = new HashMap<>();

        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            results.computeIfAbsent(firstEmail, e -> new HashSet<>());

            for (int i = 2; i < account.size(); i++) {
                String email = account.get(i);

                results.get(firstEmail).add(email);
                results.computeIfAbsent(email, e -> new HashSet<>()).add(firstEmail);
            }
        }

        return results;
    }

    private static Map<String, String> buildEmailsToNamesMap(List<List<String>> accounts) {
        Map<String, String> result = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                result.put(email, name);
            }
        }

        return result;
    }

    private static List<List<String>> mergeAccounts(Map<String, Set<String>> emailGraph, Map<String, String> emailsToNamesMap) {
        List<List<String>> results = new ArrayList<>();

        Set<String> visitedEmails = new HashSet<>();

        for (String email : emailGraph.keySet()) {
            if (visitedEmails.contains(email)) {
                continue;
            }

            List<String> result = new ArrayList<>();

            Queue<String> bfs = new LinkedList<>();
            bfs.add(email);

            while (!bfs.isEmpty()) {
                String node = bfs.remove();
                if (visitedEmails.contains(node)) {
                    continue;
                }

                result.add(node);
                visitedEmails.add(node);

                Set<String> nextNodes = emailGraph.get(node);
                bfs.addAll(nextNodes);
            }

            Collections.sort(result);

            String name = emailsToNamesMap.get(email);
            result.add(0, name);

            results.add(result);
        }

        return results;
    }
}
