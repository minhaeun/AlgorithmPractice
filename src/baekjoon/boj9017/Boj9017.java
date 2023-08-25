package baekjoon.boj9017;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj9017 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj9017/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList;
        int[] teams;
        ArrayList<Integer>[] arrayLists;

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            teams = new int[201];
            arrayList = new ArrayList<>();
            arrayLists = new ArrayList[201];
            for(int i = 1; i < 201; i++)    arrayLists[i] = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                int teamNum = Integer.parseInt(st.nextToken());
                teams[teamNum]++;
                arrayList.add(teamNum);
            }

            for(int i = 1; i < 201; i++){
                if(teams[i] < 6)    while(arrayList.remove(Integer.valueOf(i)));
            }

            for(int i = 0; i < arrayList.size(); i++){
                int teamNum = arrayList.get(i);
                arrayLists[teamNum].add(i + 1);
            }
            int min = Integer.MAX_VALUE, minIndex = 0;
            for(int i = 1; i < 201; i++){
                if(arrayLists[i].isEmpty()) continue;
                int sum = 0;
                for(int j = 0; j < 4; j++){
                    sum += arrayLists[i].get(j);
                }
                if(min > sum){
                    min = sum;
                    minIndex = i;
                } else if (min == sum) {
                    if(arrayLists[minIndex].get(4) > arrayLists[i].get(4)){
                        min = sum;
                        minIndex = i;
                    }
                }
            }
            sb.append(minIndex).append("\n");
        }
        System.out.println(sb);
    }
}
