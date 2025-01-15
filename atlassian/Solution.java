import java.util.*;
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;
        int contentChildren = 0;

        // Try to satisfy each child's greed with the smallest available cookie
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                contentChildren++;
                childIndex++;
            }
            cookieIndex++;
        }

        return contentChildren;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println(solution.findContentChildren(g1, s1)); // Output: 1

        // Example 2
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println(solution.findContentChildren(g2, s2)); // Output: 2
    }
}

