package arrays;

import java.util.ArrayList;

/**
* https://www.interviewbit.com/problems/first-missing-integer/
*/
public class FirstMissingInteger {
	public int firstMissingPositive(ArrayList<Integer> a) {
		Integer missing = 1;

		for (int i = 0; i < a.size(); i++) {
			if (1 <= a.get(i) && a.get(i) <= a.size()) {
				int pos = a.get(i) - 1;

				if (a.get(pos) != a.get(i)) {
					int tmp = a.get(pos);
					a.set(pos, a.get(i));
					a.set(i, tmp);

					i--;
				}
			}
		}

		for (int i = 0; i < a.size(); i++) {
			if (i + 1 != a.get(i))
				return i + 1;
		}

		return a.size() + 1;
	}
}
