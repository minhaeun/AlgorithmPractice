package baekjoon.data_structure.boj11003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj11003 {
    static int N, L;
    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj11003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        Deque<Node> deque = new LinkedList<>();

        for(int i = 0; i < N; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!deque.isEmpty() && deque.getLast().value > now){
                deque.removeLast();
            }

            deque.addLast(new Node(now, i));

            if(deque.getFirst().index <= i - L){
                deque.removeFirst();
            }

            sb.append(deque.getFirst().value + " ");

        }

        System.out.println(sb);




    }
}
