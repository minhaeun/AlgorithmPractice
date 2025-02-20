package programmers.pccp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class P340211 {
    public static int map[][];
    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static class Robot{
        Point point;
        ArrayList<Point> pointList;
        Robot(Point point){
            this.point = point;
            this.pointList = new ArrayList<>();
        }

        public boolean movePoint(int[][] map){
            if(pointList.size() > 0 && pointList.get(0).r == point.r && pointList.get(0).c == point.c) pointList.remove(0);
            map[point.r][point.c]--;
            if(pointList.size() == 0) return false;
            if(pointList.get(0).r != point.r){
                if(pointList.get(0).r > point.r) point.r++;
                else point.r--;
            }else if(pointList.get(0).c != point.c){
                if(pointList.get(0).c > point.c) point.c++;
                else point.c--;
            }
            map[point.r][point.c]++;
            return true;
        }
    }
    public static int solution(int[][] points, int[][] routes) {
        int answer = 0;
        map = new int[101][101];

        ArrayList<Robot> list = new ArrayList<>();
        for(int i = 0; i < routes.length; i++){
            int idx = routes[i][0] - 1;
            Point point = new Point(points[idx][0], points[idx][1]);
            Robot robot = new Robot(point);
            map[point.r][point.c]++;

            for(int j = 1; j < routes[i].length; j++){
                idx = routes[i][j] - 1;
                point = new Point(points[idx][0], points[idx][1]);
                robot.pointList.add(point);
            }
            list.add(robot);
        }
        for(int[] row : map){
            for(int value : row){
                if(value > 1) answer++;
            }
        }
        while(list.size() > 1){
            ArrayList<Integer> removeList = new ArrayList<>();
            for(int i = list.size() - 1; i >= 0; i--){
                boolean b = list.get(i).movePoint(map);
                if(!b) removeList.add(i);
            }
            for(int idx : removeList) list.remove(idx);
            for(int[] row : map){
                for(int value : row){
                    if(value > 1) answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] points1 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] points2 = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] points3 = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};

        int[][] routes1 = {{4, 2}, {1, 3}, {2, 4}};
        int[][] routes2 = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};
        int[][] routes3 = {{2, 3, 4, 5}, {1, 3, 4, 5}};

        System.out.println(solution(points1, routes1));
        System.out.println(solution(points2, routes2));
        System.out.println(solution(points3, routes3));

    }
}
