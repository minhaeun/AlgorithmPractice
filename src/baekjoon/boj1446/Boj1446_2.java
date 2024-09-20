package baekjoon.boj1446;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1446_2 {
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
        int[] arr = new int[10001];
        ArrayList<Road> list = new ArrayList<>();

        Arrays.fill(arr, 10001);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(e > D)   continue;
            if(e - s <= cost)   continue;
            list.add(new Road(s, e, cost));

        }

        Collections.sort(list, new Comparator<Road>(){
            @Override
            public int compare(Road o1, Road o2){
                if(o1.s == o2.s)    return o1.e - o2.e;
                return o1.s - o2.s;
            }
        });

        int index = 0, d = 0;
        arr[0] = 0;
        while(d < D){
            if(index >= list.size()){
                arr[d + 1] = Math.min(arr[d] + 1, arr[d + 1]);
                d++;
                continue;
            }
            Road road = list.get(index);
            if(road.s == d){
                arr[road.e] = Math.min(arr[road.e], arr[d] + road.cost);
                index++;
            }else{
                arr[d + 1] = Math.min(arr[d] + 1, arr[d + 1]);
                d++;
            }
        }

        System.out.println(arr[D]);



    }
}
