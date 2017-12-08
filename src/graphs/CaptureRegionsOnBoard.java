package graphs;

/**
* https://www.interviewbit.com/problems/capture-regions-on-board/
*/
public class CaptureRegionsOnBoard {
    private Area area;
    private Set<Cell> visited = new HashSet<>();
    
    public void solve(ArrayList<ArrayList<Character>> a) {
        if (a == null || a.size() == 0 || a.get(0) == null || a.get(0).size() == 0)
            return;

        area = new Area(a);
        for (int r = 0; r < area.height(); r++) {
            Cell cell = new Cell(r, 0);
            if (area.getCellValue(cell) == 'O')
                bfsMarkAllFromBoundary(cell);

            cell = new Cell(r, area.width() - 1);     
            if (area.getCellValue(cell) == 'O')     
                bfsMarkAllFromBoundary(cell);
        }

        for (int c = 0; c < area.width(); c++) {
            Cell cell = new Cell(0, c);
            if (area.getCellValue(cell) == 'O')
                bfsMarkAllFromBoundary(cell);
            cell = new Cell(area.height() - 1, c);
            if (area.getCellValue(cell) == 'O')     
                bfsMarkAllFromBoundary(cell);
        }

        for (int r = 0; r < area.height(); r++) {
            for (int c = 0; c < area.width(); c++) {
                Cell cell = new Cell(r, c);

                if (area.getCellValue(cell) == 'O')
                    area.setCellValue(cell, 'X');
                if (area.getCellValue(cell) == 'B')
                    area.setCellValue(cell, 'O');
            }
        }
    }

    private void bfsMarkAllFromBoundary(Cell cell) {
        Queue<Cell> q = new ArrayDeque<>();
        q.offer(cell);
        area.setCellValue(cell, 'B');

        boolean opened = false;
        while (!q.isEmpty()) {
            Cell cur = q.poll();

            for (Cell neighbour : cur.neighbours()) {
                if (area.isValid(neighbour) && 
                    area.getCellValue(neighbour) == 'O') {
                    q.offer(neighbour);
                    area.setCellValue(neighbour, 'B');
                }
            }
        }
    }

    private static class Area {
        private final ArrayList<ArrayList<Character>> area;
        private final int width;
        private final int height;

        private Area(ArrayList<ArrayList<Character>> a) {
            area = a;
            height = a.size();
            width = a.get(0).size();
        }

        private int width() {
            return width;
        }

        private int height() {
            return height;
        }

        private Character getCellValue(Cell cell) {
            return area.get(cell.r).get(cell.c);
        }

        private void setCellValue(Cell cell, Character ch) {
            area.get(cell.r).set(cell.c, ch);
        }

        private boolean isValid(Cell cell) {
            return cell.r >= 0 && cell.r < height && cell.c >= 0 && cell.c < width;
        }
    }

    private static class Cell {
        private final int[][] dirs = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        private final int r;
        private final int c;

        private Cell(int row, int col) {
            this.r = row;
            this.c = col;
        }

        private Set<Cell> neighbours() {
            Set<Cell> ngbrs = new HashSet<>();

            for (int i = 0; i < dirs.length; i++)
                ngbrs.add(new Cell(r + dirs[i][0], c + dirs[i][1]));    

            return ngbrs;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return r == cell.r && c == cell.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }   
}
