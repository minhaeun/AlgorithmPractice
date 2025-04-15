package programmers.dfsBfs;

import java.util.*;

public class P43164 {
    public static int len;
    public static boolean[] visited;
    public static ArrayList<String> list;
    public static String[] solution(String[][] tickets) {
        int count = 0;
        len = tickets.length;
        visited = new boolean[len];
        list = new ArrayList<>();

        dfs("ICN", "ICN", tickets, count);
        Collections.sort(list);

        return list.get(0).split(" ");
    }

    public static void dfs(String start, String route, String[][] tickets, int count){
        if(count == len){
            list.add(route);
            return;
        }

        for(int i = 0; i < len; i++){
            if(!start.equals(tickets[i][0]) || visited[i]) continue;
            visited[i] = true;
            dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        System.out.println(Arrays.toString(solution(tickets1)));
        System.out.println(Arrays.toString(solution(tickets2)));
    }
}
