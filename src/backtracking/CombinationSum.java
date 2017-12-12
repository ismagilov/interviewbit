package backtracking;

public class CombinationSum {
    private ArrayList<ArrayList<Integer>> combs;

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target) {
      combs = new ArrayList<>();

        arr.sort(Comparator.naturalOrder());

      int end = 1;
      for (int i = 1; i < arr.size(); i++) {
          if (arr.get(i) != arr.get(i - 1)) {
              arr.set(end, arr.get(i));
              end++;
          }
      }

      //Created sorted array of numbers without duplicates:
      //ArrayList<Integer> numbers = new ArrayList<>(new TreeSet<>(arr));

      findNextComb(arr.subList(0, end), 0, new ArrayList<>(), target);

      return combs;
    }

    private void findNextComb(List<Integer> numbers, int idx, List<Integer> comb, int target) {
      if (target == 0) {
          combs.add(new ArrayList<>(comb));
          return;
      } 

      if (target < 0)
          return;

      for (int i = idx; i < numbers.size(); i++) {
          int curNum = numbers.get(i);

          int nextTarget = target - curNum;
          if (nextTarget >= 0) { //numbers are sorted, no need to proceed with next i
              comb.add(curNum);
              findNextComb(numbers, i, comb, nextTarget);
              comb.remove(comb.size() - 1);
          }
      }

        return;	        
    }
}
