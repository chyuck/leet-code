package solutions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class RobotRoomCleanerTests {

    private enum Direction {
        TOP(-1, 0),
        BOTTOM(1, 0),
        LEFT(0, -1),
        RIGHT(0, 1);

        private static final Map<Direction, Direction> nextLeft = new HashMap<>();
        private static final Map<Direction, Direction> nextRight = new HashMap<>();

        static {
            nextLeft.put(TOP, LEFT);
            nextLeft.put(LEFT, BOTTOM);
            nextLeft.put(BOTTOM, RIGHT);
            nextLeft.put(RIGHT, TOP);

            nextRight.put(TOP, RIGHT);
            nextRight.put(RIGHT, BOTTOM);
            nextRight.put(BOTTOM, LEFT);
            nextRight.put(LEFT, TOP);
        }

        final int row;
        final int col;

        Direction(int row, int col) {
            this.row = row;
            this.col = col;
        }

        static Direction getNextLeft(Direction direction) {
            return nextLeft.get(direction);
        }

        static Direction getNextRight(Direction direction) {
            return nextRight.get(direction);
        }
    };

    private static class RobotImpl implements RobotRoomCleaner.Robot {
        private final int[][] room;
        private int row;
        private int col;

        private final int n;
        private final int m;

        private Direction direction = Direction.TOP;

        private final int[][] cleaned;

        public RobotImpl(int[][] room, int row, int col) {
            this.room = room;
            this.row = row;
            this.col = col;

            this.n = room.length;
            this.m = room[0].length;

            cleaned = new int[n][m];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    cleaned[r][c] = room[r][c] == 1 ? 1 : 0;
                }
            }
        }

        @Override
        public boolean move() {
            int newRow = row + direction.row;
            int newCol = col + direction.col;

            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) {
                return false;
            }

            if (room[newRow][newCol] == 1) {
                row = newRow;
                col = newCol;

                return true;
            }

            return false;
        }

        @Override
        public void turnLeft() {
            direction = Direction.getNextLeft(direction);
        }

        @Override
        public void turnRight() {
            direction = Direction.getNextRight(direction);
        }

        @Override
        public void clean() {
            cleaned[row][col] = 0;
        }

        public boolean allCleaned() {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (cleaned[r][c] == 1) {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    @Test
    public void testExample1() {
        // arrange
        var room = new int[][] {
            {1,1,1,1,1,0,1,1},
            {1,1,1,1,1,0,1,1},
            {1,0,1,1,1,1,1,1},
            {0,0,0,1,0,0,0,0},
            {1,1,1,1,1,1,1,1},
        };

        var robot = new RobotImpl(room, 1, 3);

        var solution = new RobotRoomCleaner();

        // act
        solution.cleanRoom(robot);

        // assert
        Assert.assertTrue(robot.allCleaned());
    }
}
