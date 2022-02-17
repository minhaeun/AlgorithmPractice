package baekjoon.boj2022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2022 {
    static double x, y, c;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2022/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        double l = 0;

        double left = 0, right = Math.min(x, y);
        while(Math.abs(right - left) > 0.0001){
            double mid = (right + left) / 2;
            if(A(mid, c) > c){
                left = mid + 0.0001;
            }else{
                right = mid - 0.0001;
            }
        }

    }
    public static double A(double x, double c){
        double a = Math.sqrt(x*x - c*c);
        return a - (a * x / c);
    }
    public static double B(double x, double c){
        return Math.sqrt(y * y - c * c) * x / c;
    }
}
