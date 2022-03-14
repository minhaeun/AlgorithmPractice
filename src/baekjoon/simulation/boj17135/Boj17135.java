package baekjoon.simulation.boj17135;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj17135 {
    static int N, M, D, max;
    static int[][] grid;
    static ArrayList<Point> enemies;
    static Point[] archers;

    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/simulation/boj17135/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 격자판 행 (3 <= N <= 15)
        M = Integer.parseInt(st.nextToken());   // 격자판 열 (3 <= M <= 1Ω5)
        D = Integer.parseInt(st.nextToken());   // 공격 거리 제한 (1 <= D <= 10)
        grid = new int[N][M];                   // 격자판 (0 : 빈칸, 1 : 적이 있는 칸 )
        enemies = new ArrayList<>();
        archers = new Point[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1) enemies.add(new Point(i, j)); // 적 위치 arrayList 에 저장
            }
        }

        /*
        궁수는 총 3명, 궁수가 있을 수 있는 위치는 N개 => NC3(조합) 으로 궁수 위치 정하기 => 조합 개수만큼 반복 => count 변수 두고 가장 최대값이 답
        궁수가 공격할 수 있는 적 : D이하 가장 가까운 적 (같다면 가장 왼쪽), 여러 궁수가 같은 적 공격 가능
        => 궁수와 적 거리 구하는 함수 dist(궁수 위치(N+1, c), 적 위치) 사용 => D 이하 최소 거리 구하기 => 같으면 c 비교
        => 궁수 공격이 모두 끝나면 공격한 칸 visit[r][c] = true  => true인 칸 개수가 공격당한 적 수
        적은 턴마다 아래로 한 칸씩 내려옴 => 궁수 위치 r -= 1 !!!!!!!!!! => 궁수와 같은 행에 있는 적은 삭제
        격자판에 모든 적이 없으면 게임 종료 => ArrayList<Point> 로 적 위치 저장 => 비어있으면 반복문 종료
         */

        comb(0, 0);
        System.out.println(max);

    }
    public static void comb(int count, int start){
        if(count == 3){ // 궁수 3명을 뽑았으면 게임 시작
            int result = startGame();
            max = Math.max(result, max);
            return;
        }

        for(int i = start; i < M; i++){
            archers[count] = new Point(N+1, i); // 궁수 위치 추가
            comb(count + 1, i + 1);
        }
    }

    public static int startGame(){
        int time = N, count = 0;
        boolean[] check = new boolean[enemies.size()];
        while(time > 0){        // 적이 더이상 없으면 게임 종료
            ArrayList<Point> kill = new ArrayList<>();   // 죽일 적 위치 저장 배열
            int enemy_count = enemies.size();

            for(int i = 0; i < 3; i++){     // 궁수 수만큼 반복문
                archers[i].r = time;
                int min_dist = D;
                kill.add(new Point(-1,M));
                for(int j = 0; j < enemy_count; j++){   // 적의 수 만큼 궁수와의 거리 체크

                    if(check[j])    continue;   // 죽인 적이면 pass
                    int distance = dist(archers[i], enemies.get(j));
                    if(min_dist > distance || (distance == min_dist && enemies.get(j).c < kill.get(i).c)) {// 궁수와 가장 가까운 거리에 있는 적 체크
                        min_dist = dist(archers[i], enemies.get(j));
                        kill.set(i, enemies.get(j));
                    }
                }


            }

            time--;
            // 궁수 r -= 1
            for(int i = 0; i < check.length; i++){
                for(int j = 0; j < kill.size(); j++){
                    if((kill.get(j).r == enemies.get(i).r) && (kill.get(j).c == enemies.get(i).c) && !check[i]){
                        count++;
                        check[i] = true;
                    }
                }
                if(enemies.get(i).r == time){
                    check[i] = true;
                }
            }

        }
        return count;
    }

    // 궁수와 적 사이의 거리를 반환해 주는 함수
    public static int dist(Point archer, Point enemy){
        return Math.abs(archer.r - enemy.r) + Math.abs(archer.c - enemy.c);
    }
}
