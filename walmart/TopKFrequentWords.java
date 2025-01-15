import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        // Count the frequency of each word
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Use a priority queue to sort by frequency and then lexicographical order
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int freqCompare = frequencyMap.get(w1).compareTo(frequencyMap.get(w2));
            if (freqCompare == 0) {
                return w2.compareTo(w1); // Reverse lexicographical order
            }
            return freqCompare;
        });

        // Add words to the heap
        for (String word : frequencyMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); // Remove the least frequent or lexicographically larger element
            }
        }

        // Extract k elements from the heap in reverse order to get the correct order
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();

        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println(solution.topKFrequent(words1, k1)); // Output: ["i", "love"]

        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println(solution.topKFrequent(words2, k2)); // Output: ["the", "is", "sunny", "day"]
    }
}

