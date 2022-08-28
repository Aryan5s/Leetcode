class Solution {
    
    private int partition(int[][] m, int r, int c, int start, int end) {
        int p = start + (end - start) / 2;
        int value = m[r + p][c + p];

        start--;
        end++;

        while(true) {
            do { start++; } while (m[r + start][c + start] < value);
            do { end--; } while (m[r + end][c + end] > value);

            if (start >= end) return end;

            int tmp = m[r + start][c + start];
            m[r + start][c + start] = m[r + end][c + end];
            m[r + end][c + end] = tmp;
        }
    }

    private void sortDiagonally(int[][] m, int r, int c, int start, int end) {
        if (start >= end) return;

        int p = partition(m, r, c, start, end);
        sortDiagonally(m, r, c, start, p);
        sortDiagonally(m, r, c, p + 1, end);
    }

    public int[][] diagonalSort(int[][] mat) {
        int[][] m = new int[mat.length][];
        for (int i = 0; i < m.length; i++)
            m[i] = Arrays.copyOf(mat[i], mat[i].length);

        for (int i = 0; i < m[0].length; i++)
            sortDiagonally(m, 0, i, 0, Math.min(m[0].length - i, m.length) - 1);

        for (int i = 1; i < m.length; i++)
            sortDiagonally(m, i, 0, 0, Math.min(m.length - i, m[0].length) - 1);

        return m;
    }
    
}