import java.util.Arrays;

public class FriendRequests {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int ageX = ages[i];
            int lowerBound = (int) (0.5 * ageX + 7);

            int start = findFirstValid(ages, lowerBound + 1, i);
            int end = findLastValid(ages, ageX, i);

            if (start <= end && start != -1 && end != -1) {
                count += end - start + 1;
            }
        }

        return count;
    }

    private int findFirstValid(int[] ages, int target, int limit) {
        int left = 0, right = limit;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private int findLastValid(int[] ages, int target, int limit) {
        int left = 0, right = limit;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (ages[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FriendRequests solution = new FriendRequests();

        int[] ages1 = {16, 16};
        System.out.println(solution.numFriendRequests(ages1)); // Output: 2

        int[] ages2 = {16, 17, 18};
        System.out.println(solution.numFriendRequests(ages2)); // Output: 2

        int[] ages3 = {20, 30, 100, 110, 120};
        System.out.println(solution.numFriendRequests(ages3)); // Output: 3
    }
}
