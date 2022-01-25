package baekjoon.data_structure.boj10773;

import java.io.*;
import java.util.ArrayList;

public class Boj10773 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj10773/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> score = new ArrayList<>();
        int k = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i < k; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                score.add(num);
            }else {
                score.remove(score.size() - 1);
            }
        }

        for(int i = 0; i < score.size(); i++){
            sum += score.get(i);
        }
        System.out.print(sum);
    }
}
