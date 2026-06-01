class Solution {
    public boolean dfs(int[] arr, int i, boolean[] vis) {
        if (i < 0 || i >= arr.length || vis[i]) return false;
        if (arr[i] == 0) return true;
        vis[i] = true;
        return dfs(arr, i + arr[i], vis) || dfs(arr, i - arr[i], vis);
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] vis = new boolean[arr.length];
        return dfs(arr, start, vis);
    }
}