package SWEA.SWEA3124;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA3124 {
    static int V, E;
    static int[] parents;
    static Edge[] edgeList;
    public static class Edge implements Comparable<Edge>{
        int from, to;
        int weight;

        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void makeSet(){
        parents = new int[V + 1];
        for(int i = 1; i < V + 1; i++){
            parents[i] = i;
        }
    }

    public static int findSet(int a){
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot)  return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/SWEA/SWEA3124/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parents = new int[V + 1];
            edgeList = new Edge[E];

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(from, to, weight);
            }

            Arrays.sort(edgeList);
            makeSet();

            long result = 0;
            int cnt = 0;

            for(Edge edge : edgeList){
                if(union(edge.from, edge.to)){
                    result += edge.weight;
                    if(++cnt == V) break;
                }
            }

        sb.append("#").append(tc).append(" ").append(result).append("\n");
        } // end of testCase
        System.out.println(sb.toString());
    }// end of Main
}// end of class
