package programmers.codeChallenge2025;

import java.util.ArrayList;

public class P388352 {
    public static boolean[] visited;
    public static int arr[], answer;
    public static ArrayList<Integer> list;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;

        arr = new int[5];
        visited = new boolean[n + 1];
        dfs(1, 0, n, q, ans);

        return answer;
    }

    public static void dfs(int start, int count, int n, int[][] q, int[] ans){
        if(count == 5){
            list = new ArrayList<>();
            for(int i = 0; i < 5; i++){
                list.add(arr[i]);
            }
            check(q, ans);
            return;
        }

        for(int i = start; i < n + 1; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[count] = i;
            dfs(i, count + 1, n, q, ans);
            visited[i] = false;
        }
    }
    public static void check(int[][] q, int[] ans){
        int len = q.length;
        for(int i = 0; i < len; i++){
            int count = 0;
            for(int j = 0; j < 5; j++){
                if(list.contains(q[i][j])) count++;
            }
            if(count != ans[i]) return;
        }
        answer++;
    }
    public static void main(String[] args) {

    }
}
