class DataStream {
    private int value;
    private int k;
    private int count;
    private int lastValue;

    // Constructor to initialize the DataStream object
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.count = 0;
        this.lastValue = Integer.MIN_VALUE; // To track the last processed value
    }

    // Method to add a number to the stream and check if the last k numbers are equal to value
    public boolean consec(int num) {
        if (num == value) {
            if (lastValue == value) {
                count++; // Increment if same value continues
            } else {
                count = 1; // Reset counter for a new streak
            }
        } else {
            count = 0; // Reset if value breaks
        }
        lastValue = num; // Update the last value
        return count >= k;
    }
}

public class Main {
    public static void main(String[] args) {
        DataStream dataStream = new DataStream(4, 3); // value = 4, k = 3
        System.out.println(dataStream.consec(4)); // false, only 1 integer parsed
        System.out.println(dataStream.consec(4)); // false, only 2 integers parsed
        System.out.println(dataStream.consec(4)); // true, last 3 integers are 4
        System.out.println(dataStream.consec(3)); // false, last 3 integers are [4, 4, 3]
    }
}

