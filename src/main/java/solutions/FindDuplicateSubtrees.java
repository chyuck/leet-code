package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import structures.TreeNode;

/**
 * Solution for https://leetcode.com/problems/find-duplicate-subtrees/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> results = new ArrayList<>();

        getId(root, new int[] { 0 }, new HashMap<>(), new HashMap<>(), results);

        return results;
    }

    private static int getId(TreeNode node, int[] idGenerator, Map<String, Integer> ids, Map<Integer, Integer> counts, List<TreeNode> results) {
        if (node == null) {
            return 0;
        }

        String key = node.val + "#" + getId(node.left, idGenerator, ids, counts, results) + "#" + getId(node.right, idGenerator, ids, counts, results);
        Integer id = ids.computeIfAbsent(key, k -> ++idGenerator[0]);

        Integer count = counts.getOrDefault(id, 0);
        counts.put(id, ++count);
        if (count == 2) {
            results.add(node);
        }

        return id;
    }
}
