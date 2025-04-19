package programmers.kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P81302 {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static char[][] arr;
    public static ArrayList<Point> list;
    public static class Point{
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        int index = 0;

        for(int i = 0; i < 5; i++){
            arr = new char[5][5];
            list = new ArrayList<>();
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    arr[j][k] = places[i][j].charAt(k);
                    if(arr[j][k] == 'P') list.add(new Point(j, k));
                }
            }
            int size = list.size();
            boolean flag = true;
            OUTER : for(int j = 0; j < size; j++){
                Queue<Point> queue = new LinkedList<>();
                Point point = list.get(j);
                queue.offer(point);
                int r = point.r;
                int c = point.c;

                while(!queue.isEmpty()){
                    Point now = queue.poll();
                    for(int d = 0; d < 4; d++){
                        int nr = now.r + dr[d];
                        int nc = now.c + dc[d];
                        if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || (nr == r && nc == c)) continue;
                        int dis = Math.abs(nr - r) + Math.abs(nc - c);
                        if(arr[nr][nc] == 'P' && dis <= 2){
                            flag = false;
                            break OUTER;
                        }
                        else if(arr[nr][nc] == 'O' && dis < 2)
                            queue.add(new Point(nr, nc));
                    }
                }
            }
            if(flag) answer[index++] = 1;
            else answer[index++] = 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        String[][] places1 = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places1)));
    }
}
