package baekjoon.boj1406;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Boj1406_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1406/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();

        for(int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }

        ListIterator<Character> iter = list.listIterator();

        while(iter.hasNext())   iter.next();

        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            switch (cmd){
                case "L" :
                    if(iter.hasPrevious())  iter.previous();
                    break;
                case "D" :
                    if(iter.hasNext())  iter.next();
                    break;
                case "B" :
                    if(iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case "P" :
                    char ch = st.nextToken().charAt(0);
                    iter.add(ch);
                    break;
            }
        }
        for(Character ch : list)    sb.append(ch);
        System.out.println(sb);
    }
}
