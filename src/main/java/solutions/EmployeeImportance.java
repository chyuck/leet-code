package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Solution for https://leetcode.com/problems/employee-importance/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class EmployeeImportance {

    static class Employee {
        public final int id;
        public final int importance;
        public final List<Integer> subordinates;

        Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    };

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> ids = employees.stream().
            collect(Collectors.toMap(e -> e.id, e -> e));

        int result = 0;

        Queue<Employee> bfs = new LinkedList<>();
        bfs.add(ids.get(id));

        while (!bfs.isEmpty()) {
            Employee employee = bfs.remove();
            result += employee.importance;

            for (Integer subordinateId : employee.subordinates) {
                bfs.add(ids.get(subordinateId));
            }
        }

        return result;
    }
}
