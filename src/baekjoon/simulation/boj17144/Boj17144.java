
package baekjoon.simulation.boj17144;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17144 {
    static int R, C, T;
    static int[][] map;
    static Queue<Dust> dustQueue;
    static Cleaner cleaner1, cleaner2;
    static int[] dr = {-1, 0, 1, 0};    // 상, 우, 하, 좌   (반 시계방향)
    static int[] dc = {0, 1, 0, -1};
    static int[] dr2 = {1, 0, -1, 0};   // 하, 우, 상, 좌  (시계 방향 )
    static int[] dc2 = {0, 1, 0, -1};

    public static class Dust{
        int r, c, amount;
        Dust(int r, int c, int amount){
            this.r = r;
            this.c = c;
            this.amount = amount;
        }
    }

    public static class Cleaner{
        int r, c;
        Cleaner(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/simulation/boj17144/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());       // 행 입력
        C = Integer.parseInt(st.nextToken());       // 열 입력
        T = Integer.parseInt(st.nextToken());       // 시간 입력
        map = new int[R][C];                        // 기존 맵 입력
        dustQueue = new LinkedList<>();             // 먼지 정보가 담긴 큐



        // 입력 시작
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                // 입력이 -1이면 공기청정기의 위치이므로 따로 저장
                if(map[i][j] == -1){
                    // 공기청정기 아랫부분 좌표 저장
                    cleaner2 = new Cleaner(i, j);
                }
                // 입력이 0이 아니면 먼지가 있는 위치 이므로 큐에 저장
                else if(map[i][j] != 0){
                    dustQueue.add(new Dust(i, j, map[i][j]));
                }
            }
        }
        // 공기청정기 윗 부분 좌표 저장
        cleaner1 = new Cleaner(cleaner2.r - 1, cleaner2.c );


        /* 1초 동안 일어나는 일
              1. 미세먼지 확산   - 모든 칸에서 동시에 일어나므로 기존 미세먼지 양과 합쳐지지 않게 새로운 map을 만들자
                             - 미세먼지는 4방으로 퍼지는데 공기청정기위치나 범위가 넘어가는 경우는 확산 X ,
                             - 확산되는 양은 5로 나눈 값(나머지 버림)
                             - 남은 미세먼지 양은 기존 미세먼지 양 - 나눠준 값 으로 계산
              2. 공기청정기 작동 - 공기청정기의 위쪽은 반시계방향(우->상->좌->하) 아래쪽은 시계방향(우->하->좌->상)
                             - 한칸씩 이동
                             - 공기청정기로 들어간 미세먼지는 정화.
         */


        //  T초 동안 반복문 실행
        for(int t = 0; t < T; t++){
            // 미세먼지 확산
            spread();
            // 공기청정기 작동
            runCleaner();
        }
        sb.append(getSum());
        System.out.println(sb.toString());

    }

    // 미세먼지 확산 함수
    public static void spread(){
        // 큐가 비어있으면 map 탐색해서 값 채워주기
        if(dustQueue.isEmpty()){
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(map[i][j] != -1 && map[i][j] != 0)   dustQueue.add(new Dust(i, j, map[i][j]));
                }
            }
        }

        // 확산된 먼지와 기존 먼지의 값이 겹치지 않도록 새로운 map 생성
        int[][] newMap = new int[R][C];

        // 큐에 들어있는 먼지를 다 확산 시킬때까지 반복문 돌기
        while(!dustQueue.isEmpty()){
            Dust dust = dustQueue.poll();

            // 현재 좌표
            int r = dust.r;
            int c = dust.c;
            // 4방 중 몇개 탐색 가능 한지 확인
            int cnt = 0;
            // 4방 탐색
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 넘어가거나 공기청정기가 있는 위치면 pass
                if(!isOkRange(nr, nc)) continue;

                cnt++;
                // 새로운 맵에 5로 나눈 값을 넣어줌
                newMap[nr][nc] += dust.amount / 5;
            }
            // 먼지 확산 후 남은 먼지 양 게산
            newMap[r][c] += dust.amount - (dust.amount / 5) * cnt;
        }

        // 새로운 맵에 공기 청정기 위치 체크
        newMap[cleaner1.r][cleaner1.c] = -1;
        newMap[cleaner2.r][cleaner2.c] = -1;

        // newMap을 기존 map에 복사
        for(int i = 0; i < R; i++){
            map[i] = newMap[i].clone();
        }


    }

    // 범위 체크 함수
    public static boolean isOkRange(int nr, int nc) {

        // 범위에 벗어나거나
        if (nr < 0 || nr >= R || nc < 0 || nc >= C) return false;

        // 공기청정기 위치면 return false
        if ((nr == cleaner1.r && nc == cleaner1.c) || (nr == cleaner2.r && nc == cleaner2.c)) return false;

        return true;
    }

    // 공기청정기 작동 함수
    public static void runCleaner(){

        // 값 이동(cleaner 1)
        int r1 = cleaner1.r - 1, c1 = cleaner1.c;

        for(int d = 0; d < 4; d++){
            // 범위 안벗어날때까지
            while(true){
                int nr = r1 + dr[d];
                int nc = c1 + dc[d];

                if(!isOkRange(nr, nc) || nr > cleaner1.r){
                    // 공기청정기에서 새로 나오는 바람은 0
                    if(nr == cleaner1.r && nc == cleaner1.c)    map[r1][c1] = 0;
                    break;
                }

                map[r1][c1] = map[nr][nc];
                r1 = nr;
                c1 = nc;
            }
        }

        // 값 이동(cleaner 2)
        int r2 = cleaner2.r + 1, c2 = cleaner2.c;

        for(int d = 0; d < 4; d++){
            // 범위 안벗어날때까지
            while(true){
                int nr = r2 + dr2[d];
                int nc = c2 + dc2[d];

                if(!isOkRange(nr, nc) || nr < cleaner2.r){
                    // 공기청정기에서 새로 나오는 바람은 0
                    if(nr == cleaner2.r && nc == cleaner2.c)    map[r2][c2] = 0;
                    break;
                }

                map[r2][c2] = map[nr][nc];
                r2 = nr;
                c2 = nc;
            }
        }
    }

    // 먼지의 총 양 구하는 함수
    public static int getSum(){
        int sum = 0;
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                sum += map[r][c];
            }
        }
        // 공기청정기로 -2 된 값 다시 더해주기
        return sum + 2;
    }


}
