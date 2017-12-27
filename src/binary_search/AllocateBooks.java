public class Solution {
    public int books(ArrayList<Integer> pages, int students) {
        if (pages.size() < students)
            return -1;

        int totalPages = 0;
        
        for (int p : pages)
            totalPages += p;
            
        int b = 0;
        int e = totalPages;
        
        int res = Integer.MAX_VALUE;
        while (b <= e) {
            int mid = b + (e - b) / 2;
            
            if (requiredForMaxPagesPerOne(pages, students, mid) <= students) {
                res = Math.min(res, mid);
                
                e = mid - 1;
            } else {
                b = mid + 1;
            } 
        }
        
        return res != Integer.MAX_VALUE ? res : -1;
    }
    
    private int requiredForMaxPagesPerOne(ArrayList<Integer> pages, 
        int students, int maxPerOne) {
        
        int required = 1;
        int curPages = 0;
        for (Integer p : pages) {
            if (p > maxPerOne)
                return Integer.MAX_VALUE;
                
            if (curPages + p > maxPerOne) {
                required++;    
                
                curPages = p;
            } else {
                curPages += p;
            }
        }
        
        return required;
    }
}
