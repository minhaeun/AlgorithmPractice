package programmers.kakao2021;

public class P4 {
    public static void main(String[] args) {
        int n1 = 6, s1 = 4, a1 = 6, b1 = 2, fares1[][] = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        System.out.println(solution(n1, s1, a1, b1, fares1));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] node = new int[n + 1][n + 1];
        for(int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                node[i][j] = 10000000;
            }
            node[i][i] = 0;
        }
        for(int i = 0; i < fares.length; i++){
            node[fares[i][0]][fares[i][1]] = fares[i][2];
            node[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        for(int k = 1; k < n + 1; k++){
            for(int i = 1; i < n + 1; i++){
                for(int j = 1; j < n + 1; j++){
                    node[i][j] = Math.min(node[i][k] + node[k][j], node[i][j]);
                }
            }
        }
        int cost = node[s][a] + node[s][b];
        for(int i = 1; i < n + 1; i++){
            cost = Math.min(cost, node[s][i] + node[i][a] + node[i][b]);
        }
        return cost;
    }
}
