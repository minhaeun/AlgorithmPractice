package programmers.weeklyChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class P3 {
    static int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        arr = new int[n+1][n+1];

        for(int i = 0; i < wires.length; i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        for(int i = 0; i < wires.length; i++){
            arr[wires[i][0]][wires[i][1]] = 0;
            arr[wires[i][1]][wires[i][0]] = 0;



            answer = Math.min(answer, bfs(n, wires[i][0]));

            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;

        }

        return answer;
    }

    public static int bfs(int depth, int num){
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[depth+1];
        int count = 1;

        queue.offer(num);

        while(!queue.isEmpty()){
            int node = queue.poll();
            visit[node] = 1;

            for(int i = 0; i < depth; i++){
                if(visit[i+1] == 1) continue;
                if(arr[node][i+1] == 1){
                    queue.offer(i+1);
                    count++;
                }
            }

        }
        return Math.abs(count - (depth-count));
    }
    public static void main(String[] args) {

    }
}
