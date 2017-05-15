package arrays;

import java.util.Comparator;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/largest-number/
 */
public class LargestNumber {
    // DO NOT MODIFY THE LIST
    public String largestNumber(final List<Integer> a) {
        a.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString() + o2.toString();
                String s2 = o2.toString() + o1.toString();

                return s2.compareTo(s1);
            }
        });

        StringBuilder sb = new StringBuilder();
        if (a.get(0) == 0)
            return "0";

        for (int i = 0; i < a.size(); i++)
            sb.append(a.get(i));

        return sb.toString();
    }
}
