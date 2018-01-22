package trees;

/**
* https://www.interviewbit.com/problems/order-of-people-heights/
*
* Sort by height descending and insert into index equal to number of people in front.
*/
public class OrderOfPeopleHeightsA {
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> fronts) {
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < heights.size(); i++)
            persons.add(new Person(heights.get(i), fronts.get(i)));
            
        persons.sort(Comparator.<Person>comparingInt(o -> o.height)
        .thenComparingInt(o -> o.front).reversed()); 
        
        ArrayList<Integer> res = new ArrayList<>();
        for (Person p : persons)
            res.add(p.front, p.height);
        
        return res;
    }
    
    private final class Person {
        int height;
        int front;
        
        private Person(int h, int f) {
            this.height = h;
            this.front = f;
        }
        
        public String toString() {
            return height + ":" + front;
        }
    }
}
