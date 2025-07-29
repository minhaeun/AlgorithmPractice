package programmers.zip;

import java.util.ArrayList;

public class P134239 {
    public static int n;
    public static double[] arr;
    public static ArrayList<Integer> list;
    public double[] solution(int k, int[][] ranges) {
        double[] answer;
        list = new ArrayList<>();
        list.add(k);
        dfs(k);

        n = list.size() - 1;
        arr = new double[n];
        for(int i = 0; i < n; i++){
            int x1 = list.get(i);
            int x2 = list.get(i + 1);
            double value = (x1 + x2) / 2.0;
            arr[i] = value;
        }

        int len = ranges.length;

        answer = new double[len];
        for(int i = 0; i < len; i++){
            int a = ranges[i][0];
            int b = ranges[i][1];
            int c = n + b;
            if(a == c) answer[i] = 0;
            else if(a > c) answer[i] = -1;
            else{
                double sum = 0;
                for(int j = a; j < c; j++){
                    sum += arr[j];
                }
                answer[i] = sum;
            }
        }
        return answer;
    }

    public static void dfs(int k){
        if(k == 1)  return;
        if(k % 2 == 0){
            k /= 2;
            list.add(k);
            dfs(k);
        }else{
            k = k * 3 + 1;
            list.add(k);
            dfs(k);
        }
    }
    public static void main(String[] args) {

    }
}
