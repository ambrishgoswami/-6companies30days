import java.util.Stack;

class Solution3{
    public static String printMinNumberForPattern(String S) {
        // Stack to hold digits temporarily
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int num = 1; // Start with the smallest digit

        for (char ch : S.toCharArray()) {
            stack.push(num++); // Push the current digit onto the stack
            if (ch == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop()); // Pop digits for 'I'
                }
            }
        }

        // Push the last number and empty the stack
        stack.push(num);
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example 1
        String pattern1 = "D";
        System.out.println(printMinNumberForPattern(pattern1)); // Output: 21

        // Example 2
        String pattern2 = "IIDDD";
        System.out.println(printMinNumberForPattern(pattern2)); // Output: 126543
    }
}
