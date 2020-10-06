package solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/robot-room-cleaner/ problem with
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n - number of cells to clean
 */
public class RobotRoomCleaner {

    interface Robot {
        boolean move();
        void turnLeft();
        void turnRight();
        void clean();
    }

    private static final int[][] DIRECTIONS = new int[][] { {-1,0}, {0,1}, {1,0}, {0,-1} };

    public void cleanRoom(Robot robot) {
        cleanRoom(robot, 0, 0, 0, new HashSet<>());
    }

    private static void cleanRoom(Robot robot, int row, int col, int direction, Set<String> visited) {
        robot.clean();
        visited.add(row + "#" + col);

        for (int d = 0; d < DIRECTIONS.length; d++) {
            int newDirection = (direction + d) % DIRECTIONS.length;

            int newRow = row + DIRECTIONS[newDirection][0];
            int newCol = col + DIRECTIONS[newDirection][1];

            if (!visited.contains(newRow + "#" + newCol) && robot.move()) {
                cleanRoom(robot, newRow, newCol, newDirection, visited);
            }

            robot.turnRight();
        }

        moveBack(robot);
    }

    private static void moveBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
