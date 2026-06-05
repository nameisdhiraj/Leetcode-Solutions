class Solution {

    String s;
    int n;

    long[][] dpCount;
    long[][] dpWave;
    boolean[][] vis;

    private long[] solve(int pos, int prevPrev, int prev,
                         boolean tight, boolean leadingZero) {

        if (pos == n) {
            return new long[]{1L, 0L};
        }

        int key = (prevPrev < 0 ? 0 : prevPrev) * 10
                + (prev < 0 ? 0 : prev);

        if (!tight && !leadingZero &&
            prevPrev >= 0 && prev >= 0 &&
            vis[pos][key]) {

            return new long[]{
                dpCount[pos][key],
                dpWave[pos][key]
            };
        }

        long totalCount = 0;
        long totalWave = 0;

        int limit = tight ? s.charAt(pos) - '0' : 9;

        for (int digit = 0; digit <= limit; digit++) {

            boolean nextLeadingZero =
                leadingZero && digit == 0;

            int nextPrevPrev = prev;
            int nextPrev = nextLeadingZero ? -1 : digit;

            long[] res = solve(
                pos + 1,
                nextPrevPrev,
                nextPrev,
                tight && digit == limit,
                nextLeadingZero
            );

            long count = res[0];
            long wave = res[1];

            totalCount += count;
            totalWave += wave;

            // Check whether 'prev' forms a peak/valley
            if (!nextLeadingZero &&
                prevPrev >= 0 &&
                prev >= 0) {

                boolean peak =
                    prevPrev < prev && prev > digit;

                boolean valley =
                    prevPrev > prev && prev < digit;

                if (peak || valley) {
                    totalWave += count;
                }
            }
        }

        if (!tight && !leadingZero &&
            prevPrev >= 0 && prev >= 0) {

            vis[pos][key] = true;
            dpCount[pos][key] = totalCount;
            dpWave[pos][key] = totalWave;
        }

        return new long[]{totalCount, totalWave};
    }

    private long calculate(long num) {

        if (num < 100) {
            return 0;
        }

        s = Long.toString(num);
        n = s.length();

        dpCount = new long[n + 1][100];
        dpWave = new long[n + 1][100];
        vis = new boolean[n + 1][100];

        return solve(0, -1, -1, true, true)[1];
    }

    public long totalWaviness(long num1, long num2) {
        return calculate(num2) - calculate(num1 - 1);
    }
}