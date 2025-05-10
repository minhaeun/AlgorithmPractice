package programmers.kakao2018;

public class P17679 {
    public static int R, C, answer;
    public static char[][] map;
    public static boolean[][] visited;
    public static int solution(int m, int n, String[] board) {
        R = m;
        C = n;
        answer = 0;
        map = new char[m][];
        visited = new boolean[R][C];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while(true){
            if(!find()) break;
            remove();
            move();
        }
        return answer;
    }
    public static boolean find() {
        boolean flag = false;
        for(int i = 0; i < R - 1; i++) {
            for(int j = 0; j < C - 1; j++) {
                char ch = map[i][j];
                if(ch == '.') continue;
                if(ch != map[i][j + 1] || ch != map[i + 1][j] || ch != map[i + 1][j + 1]) continue;
                visited[i][j] = true;
                visited[i][j + 1] = true;
                visited[i + 1][j] = true;
                visited[i + 1][j + 1] = true;
                flag = true;
            }
        }
        return flag;
    }
    public static void remove() {
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(visited[i][j]){
                    map[i][j] = '.';
                    answer++;
                }
            }
        }
        visited = new boolean[R][C];
    }
    public static void move() {
        for(int i = 0; i < C; i++){
            for(int j = R - 1; j >= 0; j--){
                if(map[j][i] == '.'){
                    for(int k = j - 1; k >= 0; k--){
                        if(map[k][i] == '.') continue;
                        map[j][i] = map[k][i];
                        map[k][i] = '.';
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int m1 = 4, n1 = 5; String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int m2 = 6, n2 = 6; String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(solution(m1, n1, board1));
        System.out.println(solution(m2, n2, board2));
    }

}
