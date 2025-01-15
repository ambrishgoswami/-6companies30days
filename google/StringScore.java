public class StringScore {
    
    public static int sumScores(String s) {
        int n = s.length();
        int[] z = new int[n];
        
        // Initialize variables for Z-algorithm
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }
        
        // Sum all Z-values and include the string length itself
        int totalScore = n; // s[n] contributes the length itself
        for (int i = 1; i < n; i++) {
            totalScore += z[i];
        }
        
        return totalScore;
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "babab";
        System.out.println("Output: " + sumScores(s1)); // Output: 9

        // Example 2
        String s2 = "azbazbzaz";
        System.out.println("Output: " + sumScores(s2)); // Output: 14
    }
}
