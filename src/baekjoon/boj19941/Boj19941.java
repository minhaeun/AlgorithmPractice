package baekjoon.boj19941;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj19941 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj19941/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean[] visited = new boolean[N];
        String str = br.readLine();
        for(int i = 0; i < N; i++){
            if(str.charAt(i) == 'H'){
                arrayList.add(i);
                visited[i] = true;
            }

        }

        int count = 0;
        for(int i = 0; i < arrayList.size(); i++){
            int index = arrayList.get(i);
            for(int j = index - K; j <= index + K; j++){
                if(j < 0 || j >= N) continue;
                if(!visited[j]){
                    count++;
                    visited[j] = true;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
