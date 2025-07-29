package programmers.codeChallenge2025;

public class P388353 {
    public static int N, M, answer;
    public static boolean[][] visited;
    public static char[][] map;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public int solution(String[] storage, String[] requests) {

        N = storage.length;
        M = storage[0].length();
        answer = N * M;

        map = new char[N][M];

        for(int i = 0; i < N; i++){
            map[i] = storage[i].toCharArray();
        }

        for(String request : requests){
            char ch = request.charAt(0);
            if(request.length() == 1) useTruck(ch);
            else useCrane(ch);
        }
        return answer;
    }
    public static void useCrane(char ch){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == ch){
                    answer--;
                    map[i][j] = 0;
                }
            }
        }
    }
    public static void useTruck(char ch){
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            if(!visited[i][0]) dfs(i, 0, ch);
            if(!visited[i][M - 1]) dfs(i, M - 1, ch);
        }
        for(int i = 0; i < M; i++){
            if(!visited[0][i]) dfs(0, i, ch);
            if(!visited[N - 1][i]) dfs(N - 1, i, ch);
        }
    }
    public static void dfs(int r, int c, char ch){
        visited[r][c] = true;
        if(map[r][c] == 0){
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
                dfs(nr, nc, ch);
            }
        }
        if(map[r][c] == ch){
            answer--;
            map[r][c] = 0;
        }
    }
    public static void main(String[] args) {

    }
}
