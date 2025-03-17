package programmers.zip;

public class P49994 {
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};
    public static int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];

        int r = 5, c = 5, d = 0;
        for(char ch : dirs.toCharArray()){
            if(ch == 'U') d = 0;
            if(ch == 'R') d = 1;
            if(ch == 'D') d = 2;
            if(ch == 'L') d = 3;

            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= 11 || nc >= 11) continue;
            if(!visited[nr][nc][d]){
                visited[nr][nc][d] = true;
                visited[r][c][(d + 2) % 4] = true;
                answer++;
            }
            r = nr;
            c = nc;
        }
        return answer;
    }
    public static void main(String[] args) {
        String dir1 = "ULURRDLLU";
        String dir2 = "LULLLLLLU";
        String dir3 = "UDU";

        // System.out.println(solution(dir1));
        // System.out.println(solution(dir2));
        System.out.println(solution(dir3));
    }
}
