package baekjoon.graph.boj1043;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1043 {
    static int N, M;
    static ArrayList<Integer> truths;
    static int[] parents;
    static ArrayList<Integer>[] party;

    static int find(int x) {
        if (parents[x] == x) return x;
        return find(parents[x]);
    }

    static void union(int x, int y){
        int xx = find(x);
        int yy = find(y);
        if(truths.contains(yy)){
            int tmp = xx;
            xx = yy;
            yy = tmp;

        }
        parents[yy] = xx;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/graph/boj1043/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());  // 사람 수
        M = Integer.parseInt(st.nextToken());  // 파티 수
        parents = new int[N + 1];
        party = new ArrayList[M];
        truths = new ArrayList<>();

        for(int i = 0; i < M; i++){
            party[i] = new ArrayList<>();
        }

        for(int i = 1; i < N + 1; i++){
            parents[i] = i;
        }
        String str = br.readLine();
        if(str.equals("0")){
            System.out.println(M);
            return;
        }
        st = new StringTokenizer(str, " ");
        int len = Integer.parseInt(st.nextToken());
        for(int i = 0; i < len; i++){
            truths.add(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int party_num = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            party[i].add(x);
            for(int j = 1; j < party_num; j++){
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                party[i].add(y);
            }

        }

        int count = 0;
        for(int i = 0; i < M; i++){
            boolean flag = true;
            for(int num : party[i]){
                if(truths.contains(find(parents[num]))){
                    flag = false;
                    break;
                }
            }
            if(flag)    count++;
        }
        System.out.println(count);
    }
}
