package baekjoon.graph.boj9019;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj9019 {
    private static class Calculator {
        int register;
        String history;

        Calculator(int register, String history){
            this.register = register;
            this.history = history;
        }
    }

    static int T, A, B;
    static Queue<Calculator> q = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/graph/boj9019/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            visited[A] = true;
            q.offer(new Calculator(A, ""));
            bfs();
            q.clear();
        }
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            Calculator cal = q.poll();

            if(cal.register == B) {
                System.out.println(cal.history);
                return;
            }

            int d = D(cal.register);
            int s = S(cal.register);
            int l = L(cal.register);
            int r = R(cal.register);

            if(!visited[d]) {
                visited[d] = true;
                q.offer(new Calculator(d, cal.history + "D"));
            }
            if(!visited[s]) {
                visited[s] = true;
                q.offer(new Calculator(s, cal.history + "S"));
            }
            if(!visited[l]) {
                visited[l] = true;
                q.offer(new Calculator(l, cal.history + "L"));
            }
            if(!visited[r]) {
                visited[r] = true;
                q.offer(new Calculator(r, cal.history + "R"));
            }
        }
    }

    private static int D(int number) {
        return (number * 2) % 10000;
    }

    private static int S(int number) {
        return number == 0 ? 9999 : number - 1;
    }

    private static int L(int number) {
        return ((number % 1000) * 10) + (number / 1000);
    }

    private static int R(int number) {
        return ((number % 10) * 1000) + (number / 10);
    }
}
