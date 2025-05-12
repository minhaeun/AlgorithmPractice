package programmers.bruteForce;

public class P87946 {
    public static int count;
    public static boolean visited[];
    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return count;
    }
    public static void dfs(int depth, int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > k ) continue;
            visited[i] = true;
            dfs(depth + 1, k - dungeons[i][1], dungeons);
            visited[i] = false;
        }
        count = Math.max(count, depth);
    }
    public static void main(String[] args) {
        int k1 = 80, dungeons1[][] = {{80,20},{50,40},{30,10}};

        System.out.println(solution(k1, dungeons1));
    }
}
