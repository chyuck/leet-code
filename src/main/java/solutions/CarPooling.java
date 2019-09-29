package solutions;

import java.util.ArrayList;
import java.util.Collections;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return false;

        ArrayList<int[]> locations = new ArrayList<>(trips.length * 2);
        for (int[] trip : trips) {
            if (trip[0] > capacity) return false;

            locations.add(new int[] { trip[1], trip[0] });
            locations.add(new int[] { trip[2], -trip[0] });
        }

        Collections.sort(locations, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int passengers = 0;

        for (int[] location : locations) {
            passengers += location[1];

            if (passengers > capacity) return false;
        }

        return true;
    }
}
