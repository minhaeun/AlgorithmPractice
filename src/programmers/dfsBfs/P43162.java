package programmers.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;

public class P43162 {
    public static int answer, N;
    public static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        answer = 0;
        N = n;
        visited = new boolean[N];

        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            answer++;
            dfs(i, computers, n);
        }
        return answer;
    }
    public static void dfs(int i, int[][] computers, int n ) {
        visited[i] = true;
        for(int j = 0; j < n; j++){
            if(visited[j] || computers[i][j] == 0) continue;
            dfs(j, computers, n);
        }
    }

    public static void main(String[] args) {
        int n1 = 3, computers1[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n2 = 3, computers2[][] = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(n1, computers1));
        System.out.println(solution(n2, computers2));
    }
}
