package programmers.codeChallenge2025;

public class P389479 {
    public static int solution(int[] players, int m, int k) {
        int answer = 0;

        int len = players.length;
        int[] servers = new int[24];

        for(int i = 0; i < len; i++) {
            int player = players[i];
            if(player >= m){
                if(player / m > servers[i]){
                    int count = player / m - servers[i];

                    for(int j = 0; j < k; j++){
                        if(i + j <= 23) servers[i + j] = servers[i + j] + count;
                    }
                    answer += count;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int players1[] = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, m1 = 3, k1 = 5;
        int players2[] = {0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}, m2 = 5, k2 = 1;
        int players3[] = {0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, m3 = 1, k3 = 1;

        System.out.println(solution(players1, m1, k1));
        System.out.println(solution(players2, m2, k2));
        System.out.println(solution(players3, m3, k3));
    }
}
