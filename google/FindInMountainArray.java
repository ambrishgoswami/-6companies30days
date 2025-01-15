interface MountainArray {
    int get(int index);
    int length();
}

public class FindInMountainArray {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find the peak element index
        int peak = findPeak(mountainArr, 0, n - 1);

        // Step 2: Search in the ascending part of the array
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1) {
            return index;
        }

        // Step 3: Search in the descending part of the array
        return binarySearch(mountainArr, target, peak + 1, n - 1, false);
    }

    private int findPeak(MountainArray mountainArr, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(MountainArray mountainArr, int target, int left, int right, boolean ascending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);

            if (midValue == target) {
                return mid;
            }

            if (ascending) {
                if (midValue < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (midValue > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Example usage with mock MountainArray implementation
        MountainArray mountainArr = new MountainArray() {
            private final int[] arr = {1, 2, 3, 4, 5, 3, 1};

            @Override
            public int get(int index) {
                return arr[index];
            }

            @Override
            public int length() {
                return arr.length;
            }
        };

        FindInMountainArray solver = new FindInMountainArray();
        System.out.println(solver.findInMountainArray(3, mountainArr)); // Output: 2
    }
}
