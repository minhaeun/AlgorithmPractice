package baekjoon.boj1446;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1446 {
    public static class Road{
        int s, e, cost;
        public Road(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1446/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<Road> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(e > D)   continue;
            if(e - s <= cost)   continue;
            list.add(new Road(s, e, cost));
        }

        Collections.sort(list, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                if(o1.s == o2.s)    return o1.e - o2.e;
                return o1.s - o2.s;
            }
        });

        int idx = 0, move = 0;
        int[] dist = new int[10001];
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        while(move < D){
            if(idx < list.size()){
                Road r = list.get(idx);
                if(move == r.s){
                    dist[r.e] = Math.min(dist[r.e], dist[move] + r.cost);
                    idx++;
                }else{
                    dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                    move++;
                }
            }else{
                dist[move + 1] = Math.min(dist[move + 1], dist[move] + 1);
                move++;
            }
        }
        System.out.println(dist[D]);

    }
}
