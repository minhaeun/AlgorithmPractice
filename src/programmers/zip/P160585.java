package programmers.zip;

import java.util.ArrayList;

public class P160585 {
    public static char[][] gameBoard;
    public static int oCount, xCount;
    public static int[] dr = {-1, -1, 0, 1}; // 상, 우상, 우, 우하
    public static int[] dc = {0, 1, 1, 1};
    public static ArrayList<Point> oList, xList;
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static int solution(String[] board) {

        gameBoard = new char[3][3];
        oList = new ArrayList<>();
        xList = new ArrayList<>();

        oCount = 0; xCount = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gameBoard[i][j] = board[i].charAt(j);

                if(gameBoard[i][j] == 'O'){
                    oCount++;
                    oList.add(new Point(i, j));
                }else if(gameBoard[i][j] == 'X') {
                    xCount++;
                    xList.add(new Point(i, j));
                }
            }
        }

        // 초기 상태일 때
        if(xCount == 0 && oCount == 0) return 1;
        // 후공의 개수가 많거나 1개 이상 차이일때
        if(xCount > oCount || oCount - xCount > 1) return 0;
        // 선공의 개수가 많은데 후공 승리거나 둘다 승리일 때
        if(oCount > xCount && (win() == 1 || win() == 2)) return 0;
        // 개수가 같지만 선공 승리일 때
        if(oCount ==  xCount && (win() == 0 || win() == 2)) return 0;


        return 1;
    }
    // 0 : 선공 승리, 1 : 후공 승리, 2 : 둘다 승리, 3: 무승부
    public static int win(){
        boolean flag1 = false;
        boolean flag2 = false;

        for(int i = 0; i < oCount; i++){
            int r = oList.get(i).r;
            int c = oList.get(i).c;
            if(check(r, c)) flag1 = true;
        }

        for(int i = 0; i < xCount; i++){
            int r = xList.get(i).r;
            int c = xList.get(i).c;
            if(check(r, c)) flag2 = true;
        }

        if(flag1 && flag2) return 2;
        if(flag1) return 0;
        if(flag2) return 1;

        return 3;
    }

    public static boolean check(int r, int c){
        char ch = gameBoard[r][c];


        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= 3 || nc < 0 ||  nc >= 3) continue;

            if(ch != gameBoard[nr][nc]) continue;

            nr = r + dr[d] * -1;
            nc = c + dc[d] * -1;

            if(nr < 0 || nr >= 3 || nc < 0 || nc >= 3) continue;
            if(ch != gameBoard[nr][nc]) continue;

            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        String[] board1 = {"O.X", ".O.", "..X"};
        String[] board2 = {"OOO", "...", "XXX"};
        String[] board3 = {"...", ".X.", "..."};
        String[] board4 = {"...", "...", "..."};
        String[] board5 = {"XXX", "XOO", "OOO"};

        System.out.println(solution(board1));
        System.out.println(solution(board2));
        System.out.println(solution(board3));
        System.out.println(solution(board4));
        System.out.println(solution(board5));


    }
}
