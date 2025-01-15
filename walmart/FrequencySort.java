import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        // Count frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Use a priority queue to sort characters by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        // Build the resulting string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int count = frequencyMap.get(current);
            for (int i = 0; i < count; i++) {
                result.append(current);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        FrequencySort solution = new FrequencySort();

        String s1 = "tree";
        System.out.println(solution.frequencySort(s1)); // Output: "eert" or "eetr"

        String s2 = "cccaaa";
        System.out.println(solution.frequencySort(s2)); // Output: "aaaccc" or "cccaaa"

        String s3 = "Aabb";
        System.out.println(solution.frequencySort(s3)); // Output: "bbAa" or "bbaA"
    }
}

