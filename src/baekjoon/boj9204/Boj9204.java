import java.util.*;
import java.io.*;

public class Boj9204 {
    static int ud[] = { -1, -1, 1, 1 };
    static int rl[] = { 1, -1, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start_y = st.nextToken().charAt(0) - 'A';
            int start_x = 8 - Integer.parseInt(st.nextToken());

            int finish_y = st.nextToken().charAt(0) - 'A';
            int finish_x = 8 - Integer.parseInt(st.nextToken());

            if (start_x == finish_x && start_y == finish_y)
                System.out.println("0 " + (char) ('A' + start_y) + " " + (8-start_x));
            else if ((Math.abs(start_x - finish_x) + Math.abs(start_y - finish_y)) % 2 == 1) {
                System.out.println("Impossible");
            } else {
                boolean[][] visited = new boolean[8][8];

                moveVishop(start_x, start_y, finish_x, finish_y, visited);

                if(visited[finish_x][finish_y]) {
                    System.out.println("1 " + (char) ('A' + start_y) + " " + (8-start_x) + " " + (char) ('A' + finish_y) + " " + (8-finish_x));
                    continue;
                }
                //print(visited);

                System.out.print("2 " + (char) ('A' + start_y) + " " + (8-start_x) + " ");
                moveVishop(finish_x, finish_y, finish_x, finish_y, visited);
            }
        }
    }

    private static void moveVishop(int sx, int sy, int fx, int fy, boolean[][] visited) {

        for (int i = 0; i < 4; i++) {
            int x = sx, y = sy;
            while (true) {
                visited[x][y] = true;
                int nx = x + ud[i];
                int ny = y + rl[i];

                if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8)
                    break;

                if (visited[nx][ny]) {
                    System.out.println((char) (ny + 'A') + " " + (8-nx) + " " + (char) (fy + 'A') + " " + (8-fx));
                    return;
                }

                x = nx;
                y = ny;
            }
        }
    }

    private static void print(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if (visited[i][j])
                    System.out.print("T");
                else
                    System.out.print("F");
            }
            System.out.println();
        }
    }
}