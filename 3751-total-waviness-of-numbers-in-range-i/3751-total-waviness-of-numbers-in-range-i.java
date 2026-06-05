class Solution {

    // Method to find Wavieness
    static int findWavieness(int num){
        String s = Integer.toString(num);
        int score = 0;
        if(s.length() < 3) return 0;
        for(int i = 1; i < s.length() - 1; i++){
            // checking if the number has peak
            if(s.charAt(i - 1) < s.charAt(i) && s.charAt(i + 1) < s.charAt(i)) score++;

            // checking if the number has valley
            if(s.charAt(i - 1) > s.charAt(i) && s.charAt(i + 1) > s.charAt(i)) score++;
        }
        return score;
    }


    public int totalWaviness(int num1, int num2) {
        int score = 0;
        for(int num = num1; num <= num2; num++){
            score += findWavieness(num);
        }
        return score;
    }
}