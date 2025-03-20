package programmers.kakao2022;

public class P92344 {
    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        int[][] sums = new int[r + 1][c + 1];

        for(int[] s : skill){
            int type = s[0];
            if(type == 1){
                sums[s[1]][s[2]] -= s[5];
                sums[s[3] + 1][s[2]] += s[5];
                sums[s[1]][s[4] + 1] += s[5];
                sums[s[3] + 1][s[4] + 1] -= s[5];
            } else {
                sums[s[1]][s[2]] += s[5];
                sums[s[3] + 1][s[2]] -= s[5];
                sums[s[1]][s[4] + 1] -= s[5];
                sums[s[3] + 1][s[4] + 1] += s[5];
            }
        }

        for(int j = 0;j < c + 1;j++){
            for(int i = 0;i < r;i++){
                sums[i + 1][j] += sums[i][j];
            }
        }

        for(int i = 0;i < r + 1;i++){
            for(int j = 0;j < c;j++){
                sums[i][j + 1] += sums[i][j];
            }
        }

        for(int i = 0;i < r;i++){
            for(int j = 0;j < c;j++){
                if(board[i][j] + sums[i][j] > 0) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] board1 = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, skill1 = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        int[][] board2 = {{1,2,3},{4,5,6},{7,8,9}}, skill2 = {{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};

        System.out.println(solution(board1, skill1));
        System.out.println(solution(board2, skill2));
    }
}
