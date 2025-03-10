package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class P42861 {
    public static int[] parents;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }

        int count = 0;
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            int weight = cost[2];

            if(!union(a, b)){
                answer += weight;
                count++;
                if(count == n - 1) break;
            }
        }
        return answer;
    }
    public static int find(int a){
        if(a != parents[a]) return parents[a] = find(parents[a]);
        return a;
    }
    public static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return true;
        else{
            parents[b] = a;
            return false;
        }
    }

    public static void main(String[] args) {
        int n1 = 4, costs1[][] = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        System.out.println(solution(n1, costs1));
    }
}
