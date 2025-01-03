
public class Winner{
    public int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }

  
    private int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        Winner solution = new Winner();

       
        System.out.println(solution.findTheWinner(5, 2)); 

        System.out.println(solution.findTheWinner(6, 5)); 
    }
}
