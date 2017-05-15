package arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrixI {
    private enum Dir {
        R,
        D,
        L,
        U
    }

    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<>();

        int t = 0, b = a.size() - 1, l = 0, r = a.get(0).size() - 1;
        Dir dir = Dir.R;

        while (t <= b && l <= r) {
            if (dir == Dir.R) {
                for (int i = l; i <= r; i++)
                    result.add(a.get(t).get(i));
                dir = Dir.D;
                t++;
            } else if (dir == Dir.D) {
                for (int i = t; i <= b; i++)
                    result.add(a.get(i).get(r));
                dir = Dir.L;
                r--;
            } else if (dir == Dir.L) {
                for (int i = r; i >= l; i--)
                    result.add(a.get(b).get(i));
                dir = Dir.U;
                b--;
            } else if (dir == Dir.U) {
                for (int i = b; i >= t; i--)
                    result.add(a.get(i).get(l));
                dir = Dir.R;
                l++;
            }
        }

        return result;
    }
}

