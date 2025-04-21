package programmers.zip;

public class P12905 {
    public static int solution(int[][] board) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;

        if(r < 2 || c < 2) return 1;
        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(board[i][j] != 0) board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                if(answer < board[i][j]) answer = board[i][j];
            }
        }
        return answer * answer;
    }
    public static void main(String[] args) {
        int[][] board1 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int[][] board2 = {{0,0,1,1},{1,1,1,1}};

        System.out.println(solution(board1));
        System.out.println(solution(board2));

    }
}
