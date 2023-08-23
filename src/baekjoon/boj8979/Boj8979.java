package baekjoon.boj8979;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj8979 {
    public static class Country{
        int gold, silver, bronze;
        public Country(int gold, int silver, int bronze){
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj8979/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Country countries[] = new Country[N + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            countries[n] = new Country(gold, silver, bronze);
        }

        int result = 1;
        Country k = countries[K];
        for(int i = 1; i <= N; i++){
            Country c = countries[i];
            if(c.gold > k.gold || (c.gold == k.gold && c.silver > k.silver) || (c.gold == k.gold && c.silver == k.silver && c.bronze > k.bronze))   result++;
        }
        System.out.println(result);






    }
}
