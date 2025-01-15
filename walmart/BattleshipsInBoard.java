public class BattleshipsInBoard {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the current cell is a battleship
                if (board[i][j] == 'X') {
                    // Skip if it's part of an already counted battleship
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        BattleshipsInBoard solution = new BattleshipsInBoard();

        char[][] board1 = {
            {'X', '.', '.', 'X'},
            {'.', '.', '.', 'X'},
            {'.', '.', '.', 'X'}
        };
        System.out.println(solution.countBattleships(board1)); // Output: 2

        char[][] board2 = {
            {'.'}
        };
        System.out.println(solution.countBattleships(board2)); // Output: 0
    }
}
