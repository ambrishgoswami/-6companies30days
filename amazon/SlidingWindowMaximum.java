import java.util.*;

public class SlidingWindowMaximum {

    public static List<Integer> maxSlidingWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0 || k <= 0) {
            return result;
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // Remove indices of elements not in the current window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of elements smaller than the current element
            // (as they will never be the maximum for this or any future window)
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // Add the current element's index to the deque
            deque.offerLast(i);

            // Add the maximum for the current window to the result
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k1 = 3;
        System.out.println(maxSlidingWindow(arr1, k1)); // Output: [3, 3, 4, 5, 5, 5, 6]

        int[] arr2 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k2 = 4;
        System.out.println(maxSlidingWindow(arr2, k2)); // Output: [10, 10, 10, 15, 15, 90, 90]

        int[] arr3 = {5, 1, 3, 4, 2, 6};
        int k3 = 1;
        System.out.println(maxSlidingWindow(arr3, k3)); // Output: [5, 1, 3, 4, 2, 6]
    }
}
