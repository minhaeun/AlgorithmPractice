package baekjoon.boj1015;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj1015 {
    public static class Pair{
        int idx;
        int value;

        Pair(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1015/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Pair> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arrayList.add(new Pair(i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(arrayList, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.value < o2.value) return -1;
                else if(o1.value > o2.value)    return 1;
                else{
                    if(o1.idx < o2.idx) return -1;
                    else    return 1;
                }
            }
        });

        int[] p = new int[1001];
        for(int i = 0; i < n; i++){
            p[arrayList.get(i).idx] = i;
        }

        for(int i = 0; i < n; i++){
            System.out.print(p[i] + " ");
        }



    }
}
