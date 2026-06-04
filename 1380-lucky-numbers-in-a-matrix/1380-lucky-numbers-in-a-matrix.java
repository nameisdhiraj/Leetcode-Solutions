class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] rowMin = new int[n];
        int[] colMax = new int[m];

        // Row minimums
        for(int i = 0; i < n; i++) {
            int mini = Integer.MAX_VALUE;

            for(int j = 0; j < m; j++) {
                mini = Math.min(mini, matrix[i][j]);
            }

            rowMin[i] = mini;
        }

        // Column maximums
        for(int i = 0; i < m; i++) {
            int maxi = Integer.MIN_VALUE;

            for(int j = 0; j < n; j++) {
                maxi = Math.max(maxi, matrix[j][i]);
            }

            colMax[i] = maxi;
        }

        List<Integer> ans = new ArrayList<>();

        for(int x : rowMin) {
            for(int y : colMax) {
                if(x == y) {
                    ans.add(x);
                }
            }
        }

        return ans;
    }
}