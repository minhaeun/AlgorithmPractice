package SWEA.SWEA7465;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA7465 {
    static int N, M;
    static int[] parents;

    public static void makeSet(){
        parents = new int[N + 1];

        for(int i = 1; i <= N; i++){
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
        System.setIn(new FileInputStream("./src/SWEA/SWEA7465/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            makeSet();

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            HashSet<Integer> hashSet = new HashSet<>();
            for(int i = 1; i <= N; i++){
                hashSet.add(findSet(i));
            }

            sb.append("#").append(tc).append(" ").append(hashSet.size()).append("\n");
        }
        System.out.println(sb.toString());


    }
}
