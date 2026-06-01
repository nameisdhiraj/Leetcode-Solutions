class Solution {
    public int minimumCost(int[] cost) {
        int[] hash = new int[101];
        for (int price : cost) {
            hash[price]++;
        }

        int ans = 0;
        int c = 0;
        for (int price = 100; price >= 1; price--) {

            while (hash[price] > 0) {

                if (c < 2) {
                    ans += price;
                    c++;
                }
                else {
                    c = 0;
                }

                hash[price]--;
            }
        }

        return ans;
    }
}