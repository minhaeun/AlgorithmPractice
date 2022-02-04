package SWEA.SWEA1873;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/SWEA1873/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
        int[] dc = {0, 0, -1, 1};

        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];
            int r_car = 0, c_car = 0, dir = 0;

            // map 입력받기
            for(int r = 0; r < H; r++){
                String row = br.readLine();
                for(int c = 0; c < W; c++){
                    map[r][c] = row.charAt(c);
                    if(map[r][c] == '^' || map[r][c] == 'v' || map[r][c] == '<' || map[r][c] == '>'){
                        r_car = r;
                        c_car = c;

                        if(map[r_car][c_car] == '^'){
                            dir = 0;
                        }else if(map[r_car][c_car] == 'v'){
                            dir = 1;
                        }else if(map[r_car][c_car] == '<'){
                            dir = 2;
                        }else if(map[r_car][c_car] == '>'){
                            dir = 3;
                        }
                    }
                }
            }
            //입력 개수
            int N = Integer.parseInt(br.readLine());
            // 입력 종류
            String str = br.readLine();

            for(int i = 0; i < N; i++) {
                char cur = str.charAt(i);
                int nr;
                int nc;

                if(cur ==  'S'){
                    nr = r_car;
                    nc = c_car;
                    while(true){    // 벽이 나올때까지 반복
                        nr += dr[dir];
                        nc += dc[dir];
                        //강철벽이면 pass
                        if( nr >= H || nr < 0 || nc >= W || nc < 0 || map[nr][nc] == '#')  break;
                        else if(map[nr][nc] == '*'){
                            map[nr][nc] = '.';
                            break;
                        }
                        //nr += dr[dir];
                        //nc += dc[dir];
                    }

                }else if(cur == 'U'){           // 상
                    map[r_car][c_car] = '^';
                    dir = 0;
                    nr = r_car + dr[0];
                    nc = c_car + dc[0];

                    if( nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '.'){     //평지이면
                        map[r_car][c_car] = '.';
                        map[nr][nc] = '^';
                        r_car = nr;
                        c_car = nc;
                    }
                }else if(cur == 'D'){           // 하
                    map[r_car][c_car] = 'v';
                    dir = 1;
                    nr = r_car + dr[1];
                    nc = c_car + dc[1];

                    if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '.'){     //평지이면
                        map[r_car][c_car] = '.';
                        map[nr][nc] = 'v';
                        r_car = nr;
                        c_car = nc;
                    }

                }else if(cur == 'L'){           // 좌
                    map[r_car][c_car] = '<';
                    dir = 2;
                    nr = r_car + dr[2];
                    nc = c_car + dc[2];

                    if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '.'){     //평지이면
                        map[r_car][c_car] = '.';
                        map[nr][nc] = '<';
                        r_car = nr;
                        c_car = nc;
                    }

                }else if(cur == 'R'){           // 우
                    map[r_car][c_car] = '>';
                    dir = 3;
                    nr = r_car + dr[3];
                    nc = c_car + dc[3];

                    if(nr < H && nr >= 0 && nc < W && nc >= 0 && map[nr][nc] == '.'){     //평지이면
                        map[r_car][c_car] = '.';
                        map[nr][nc] = '>';
                        r_car = nr;
                        c_car = nc;
                    }
                }

            }
            sb.append("#").append(tc).append(" ");
            for(int r = 0; r < H; r++){
                for(int c = 0; c < W; c++){
                    sb.append(map[r][c]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }
}
