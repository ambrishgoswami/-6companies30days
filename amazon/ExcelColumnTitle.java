public class ExcelColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--; // Adjust for 1-based indexing
            int remainder = columnNumber % 26;
            char ch = (char) ('A' + remainder); // Convert remainder to corresponding character
            sb.append(ch);
            columnNumber /= 26; // Move to the next significant position
        }

        // Reverse the result since we build it backwards
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle solution = new ExcelColumnTitle();

        // Test cases
        System.out.println(solution.convertToTitle(1));    // Output: "A"
        System.out.println(solution.convertToTitle(28));   // Output: "AB"
        System.out.println(solution.convertToTitle(701));  // Output: "ZY"
        System.out.println(solution.convertToTitle(2147483647)); // Test upper bound
    }
}

