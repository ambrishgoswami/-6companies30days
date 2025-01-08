

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        // Array to store the frequency of each character
        int[] charCount = new int[26];

        // Count frequencies of each character
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }

        // Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        // No non-repeating character found
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(firstUniqChar(s1)); // Output: 0

        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s2)); // Output: 2

        String s3 = "aabb";
        System.out.println(firstUniqChar(s3)); // Output: -1
    }
}

