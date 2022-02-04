package baekjoon.recursion.boj17478;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj17478 {

    public static String recursive(int n, StringBuilder sb, String blank) {
        sb.append(blank).append("\"재귀함수가 뭔가요?\"\n");
        if (n == 0) {
            sb.append(blank).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n").append(blank).append("라고 답변하였지.\n");
            return sb.toString();
        }
        sb.append(blank).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        sb.append(blank).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        sb.append(blank).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        recursive(n - 1, sb, blank + "____");

        return sb.append(blank).append("라고 답변하였지.\n").toString();
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/recursion/boj17478/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String blank = "";
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        System.out.println(recursive(N, sb, blank));


    }
}
