package baekjoon.boj21609;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj21609 {
    // block
    static public class Block{
        Point point;
        int color;

        Block(int r, int c, int color){
            this.point = new Point(r, c);
            this.color = color;
        }
    }
    // 위치 클래스
    static public class Point{
        int r, c;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    // 블록의 그룹
    static public class Group{
        int blockCnt;
        int rainbowCnt;
        Point base;

        Group(){
            this.blockCnt = 0;
            this.rainbowCnt = 0;
            this.base = new Point(-1, -1);
        }
    }

    static int N, M, map[][], score;
    static final int black = -1, rainbow = 0, empty = -2;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Group bigGroupBase;
    static Queue<Block> bigGroup = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj21609/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        score = 0;
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            if(!findBlock())    break;
            eraseBlock();
            gravity();
            rotate();
            gravity();
        }

        System.out.println(score);
    }

    static boolean findBlock(){
        bigGroup = new LinkedList<>();
        bigGroupBase = new Group();
        boolean[][] visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                // 블록색깔이 일반 블록 색깔이 아니거나 방문했으면 넘기기
                if(M < map[i][j] || map[i][j] <= rainbow || visit[i][j])    continue;
                bfs(i, j, map[i][j], visit);
            }
        }
        // 그룹에 속한 블록 개수는 2 이상
        return bigGroup.size() > 1;
    }

    static void bfs(int r, int c, int color, boolean[][] visit){
        Queue<Block> queue = new LinkedList<>();
        // 현재 블록 개수가 몇개인지 비교하기 위한 큐
        Queue<Block> tmp = new LinkedList<>();
        queue.add(new Block(r, c, color));
        tmp.add(new Block(r, c, color));
        visit[r][c] = true;

        Group tmpBase = new Group();
        tmpBase.base.r = r;
        tmpBase.base.c = c;
        tmpBase.blockCnt++;

        while(!queue.isEmpty()){
            Block cur = queue.poll();
            for(int d = 0; d < 4; d++){
                int nr = cur.point.r + dr[d];
                int nc = cur.point.c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visit[nr][nc])  continue;
                if(map[nr][nc] == color || map[nr][nc] == rainbow){
                    visit[nr][nc] = true;
                    queue.add(new Block(nr, nc, map[nr][nc]));
                    tmp.add(new Block(nr, nc, map[nr][nc]));
                    if(map[nr][nc] != rainbow){
                        // 기준 블록 개수 세기
                        tmpBase.blockCnt++;
                    }else{
                        // 무지개 블록 개수 세기
                        tmpBase.rainbowCnt++;
                    }
                }
            }
        }
        // 큰 블록 찾기
        boolean isChange = false;
        // 그룹에는 1개의 일반 블록이 있어야 함
        if(tmp.size() > 1 && tmpBase.blockCnt >= 1){
            // 그룹이 더 크면
            if(bigGroup.size() < tmp.size()){
                isChange = true;
            }else if(bigGroup.size() == tmp.size()){
                // 그룹 개수가 같으면 무지개 블록 개수가 큰 쪽
                if(bigGroupBase.rainbowCnt < tmpBase.rainbowCnt){
                    isChange = true;
                }else if(bigGroupBase.rainbowCnt == tmpBase.rainbowCnt){
                    // 무지개 블록 개수가 같으면 행이 큰쪽
                    if(bigGroupBase.base.r < tmpBase.base.r){
                        isChange = true;
                    }else if(bigGroupBase.base.r == tmpBase.base.r && bigGroupBase.base.c < tmpBase.base.c){
                        // 열이 큰 쪽
                        isChange = true;
                    }
                }
            }
        }
        // 큰 블록을 바꿀 수 있으면 바꾸기
        if(isChange){
            bigGroup.clear();
            while(!tmp.isEmpty()){
                Block cur = tmp.poll();
                if(cur.color == rainbow){
                    // 무지개블록은 다른 그룹에 속할 수 있으므로 방문체크 풀기
                    visit[cur.point.r][cur.point.c] = false;
                }
                bigGroup.add(cur);
            }
            bigGroupBase.base.r = tmpBase.base.r;
            bigGroupBase.base.c = tmpBase.base.c;
            bigGroupBase.blockCnt = tmpBase.blockCnt;
            bigGroupBase.rainbowCnt = tmpBase.rainbowCnt;
        }else{
            while(!tmp.isEmpty()){
                Block cur = tmp.poll();
                if(cur.color == rainbow){
                    visit[cur.point.r][cur.point.c] = false;
                }
            }
        }
    }

    // 가장 큰 블록에 속한 블록들 지우기
    static void eraseBlock(){
        // 점수 게산
        score += bigGroup.size() * bigGroup.size();
        while(!bigGroup.isEmpty()){
            Block cur = bigGroup.poll();
            map[cur.point.r][cur.point.c] = empty;
        }
    }

    // 블록 내리기
    static void gravity(){
        for(int j = 0; j < N; j++){
            int cnt = 0;
            for(int i = N - 1; i >= 0; i--){
                if(map[i][j] == empty){
                    ++cnt;
                }else{
                    if(map[i][j] != black && cnt > 0){  // 일반 블록이면
                        // 블록 옮기기
                        map[i + cnt][j] = map[i][j];
                        // 옮긴 현 위치 비우기
                        map[i][j] = empty;
                        i = i + cnt;
                        cnt = 0;
                    }else{  // 검은블록이면
                        cnt = 0;
                    }
                }
            }
        }
    }

    // 회전하기
    static void rotate(){
        int[][] tmp = new int[N][N];
        for(int i = 0; i < N; i++){
            int r = 0;
            for(int j = N -1; j >= 0; j--){
                tmp[r++][i] = map[i][j];
            }
        }
        map = tmp;
    }
}
