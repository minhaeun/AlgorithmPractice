package baekjoon.simulation.boj16236;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16236 {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};    // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Point> fish;
    static int size = 2;
    static int time, count;

    public static class Point{
        int r, c, dist;
        Point(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/simulation/boj16236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int shark_r = 0, shark_c = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    // 처음 상어 위치 체크
                    shark_r = i;
                    shark_c = j;
                    // 상어 위치 0으로 바꿔주기
                    map[i][j] = 0;
                }
            }
        }

        while(true){

          bfs(shark_r, shark_c);
          // 먹을 물고기가 없으면 반복문 탈출
          if(fish.size() == 0)    break;

          // 먹을 point 가져오기
          Point eatPoint = fish.get(0);


          for(int i = 1; i < fish.size(); ++i){
              // 가장 거리가 가까운 먹이부터 찾아서 먹기
              if(eatPoint.dist > fish.get(i).dist){
                  eatPoint = fish.get(i);
              }

              // 거리가 같다면 r이 작은곳 부터 먹기
              if(eatPoint.dist == fish.get(i).dist){
                  if(eatPoint.r > fish.get(i).r){
                      eatPoint = fish.get(i);
                  }
              }
          }
          // 먹은 물고기 거리만큼 시간 체크
          time += eatPoint.dist;
          // 먹은 물고기 개수
          count++;
          // 물고기 먹었으니까 0으로 바꿔서 없애주기
          map[eatPoint.r][eatPoint.c] = 0;
          // 먹은 물고기 수가 아기상어 크기랑 같으면
          if(count == size){
              // 아기상어 크기 증가, 개수 초기화
              size++;
              count = 0;
          }
          // 아기상어 좌표 갱신
          shark_r = eatPoint.r;
          shark_c = eatPoint.c;

        }
        System.out.println(time);

    }

    public static void bfs(int r, int c){
        visit = new boolean[N][N];
        // 처음 위치 방문 체크
        visit[r][c] = true;

        // 상어의 이동 경로 저장
        Queue<Point> queue = new LinkedList<>();
        // 상어가 먹을 물고기 리스트 저장
        fish = new ArrayList<>();
        // 처음 위치 큐에 저장
        queue.add(new Point(r, c, 0));

        // bfs 시작
        while(!queue.isEmpty()){
            Point shark = queue.poll();

            for(int d = 0; d < 4; d++){
                int nr = shark.r + dr[d];
                int nc = shark.c + dc[d];

                // 범위 확인
                if(nr < 0 || nr >= N || nc < 0 || nc >= N)  continue;
                // 방문 유무 확인
                if(visit[nr][nc])   continue;

                // 아기상어가 먹을 수 있는 물고기를 찾으면
                if(map[nr][nc] != 0 && map[nr][nc] < size){
                    // 상어 위치 바꿔주고 한칸 이동
                    queue.offer(new Point(nr, nc, shark.dist + 1));
                    // 먹이 리스트에 추가
                    fish.add(new Point(nr, nc, shark.dist + 1));
                    visit[nr][nc] = true;
                }
                //
                else if(map[nr][nc] == size || map[nr][nc] == 0){
                    queue.offer(new Point(nr, nc, shark.dist + 1));
                    visit[nr][nc] = true;
                }
            }

        }
    }
}
