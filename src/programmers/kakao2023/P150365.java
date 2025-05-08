package programmers.kakao2023;

public class P150365 {
    public static int R, C, K;
    public static Point E;
    public static int[] dr = {1, 0, 0, -1}; // 하, 좌, 우, 상
    public static int[] dc = {0, -1, 1, 0};
    public static String answer;
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "";
        R = n;
        C = m;
        E = new Point(r - 1, c - 1);
        K = k;

        if(Math.abs(x - r) + Math.abs(y - c) > k) return "impossible";
        //if((Math.abs(x - r) + Math.abs(y - c)) % 2 != k%2) return "impossible";


        dfs(x - 1, y - 1, "", 0);
        if(answer.isEmpty()) return "impossible";
        return answer;
    }
    public static void dfs(int r, int c, String s, int count) {
        if(!answer.isEmpty()) return;
        if(count == K) {
            if(E.r == r && E.c == c) {
                answer = s;
            }
            return;
        }
        int dist = Math.abs(E.r - r) + Math.abs(E.c - c);
        if(K - s.length() < dist) return;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if(d == 0) dfs(nr, nc, s + "d", count + 1);
            else if(d == 1) dfs(nr, nc, s + "l", count + 1);
            else if(d == 2) dfs(nr, nc, s + "r", count + 1);
            else dfs(nr, nc, s + "u", count + 1);
        }
    }
    public static void main(String[] args) {
        int n1 = 3, m1 = 4, x1 = 2, y1 = 3, r1 = 3, c1 = 1, k1 = 5;
        int n2 = 2, m2 = 2, x2 = 1, y2 = 1, r2 = 2, c2 = 2, k2 = 2;
        int n3 = 3, m3 = 3, x3 = 1, y3 = 2, r3 = 3, c3 = 3, k3 = 4;

        System.out.println(solution(n1, m1, x1, y1, r1, c1, k1));
        System.out.println(solution(n2, m2, x2, y2, r2, c2, k2));
        System.out.println(solution(n3, m3, x3, y3, r3, c3, k3));
    }
}
