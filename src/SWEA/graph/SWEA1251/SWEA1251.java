package SWEA.graph.SWEA1251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1251 {
    static int N;
    static int[] parents;
    static double[] arrX, arrY;
    static PriorityQueue<Edge> pq;
    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;
        public Edge(int from, int to, double cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            // cost 기준으로 오름차순 정렬
            return (int)(this.cost - o.cost);
        }
    }


    public static void makeSet(){
        parents = new int[N];
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }
    }

    public static int findSet(int a){
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static void union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot)  return;

        parents[bRoot] = aRoot;
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SWEA/graph/SWEA1251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            arrX = new double[N];
            arrY = new double[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                arrX[i] = Double.parseDouble(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                arrY[i] = Double.parseDouble(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            makeSet();

            pq = new PriorityQueue<>();
            for(int i = 0; i < N -1; i++){
                for(int j = i + 1; j < N; j++){
                    double dist = Math.pow((arrX[i] - arrX[j]), 2) + Math.pow((arrY[i] - arrY[j]), 2);
                    pq.offer(new Edge(i, j, dist));
                }
            }

            double cost = 0;
            while(!pq.isEmpty()){
                Edge edge = pq.poll();
                int x = findSet(edge.from);
                int y = findSet(edge.to);
                if(x == y)  continue;
                union(x, y);
                cost += E * edge.cost;
            }

        sb.append("#").append(tc).append(" ").append(Math.round(cost)).append("\n");
        }
        System.out.println(sb.toString());


    }
}
