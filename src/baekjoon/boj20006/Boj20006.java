package baekjoon.boj20006;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj20006 {
    public static int P, M;
    public static class Player{
        int level;
        String nick;
        public Player(int level, String nick){
            this.level = level;
            this.nick = nick;
        }
    }
    public static class Room{
        ArrayList<Player> players = new ArrayList<>();
        int limit, standard;

        public Room(Player player, int standard){
            this.players.add(player);
            this.standard = standard;
            this.limit = 1;
        }

    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20006/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Room> rooms = new ArrayList<>();

        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String nick = st.nextToken();

            if(rooms.isEmpty()){
                rooms.add(new Room(new Player(level, nick), level));
                continue;
            }
            boolean flag = false;
            for(Room room : rooms){
                if(Math.abs(level - room.standard) > 10 || room.limit >= M)    continue;
                else{
                    room.players.add(new Player(level, nick));
                    room.limit++;
                    flag = true;
                    break;
                }
            }
            if(!flag)   rooms.add(new Room(new Player(level, nick), level));
        }

        for(Room room : rooms){
            if(room.limit == M) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            Collections.sort(room.players, new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    return o1.nick.compareTo(o2.nick);
                }
            });

            for(int i = 0; i < room.limit; i++){
                Player player = room.players.get(i);
                sb.append(player.level).append(" ").append(player.nick).append("\n");
            }
        }
        System.out.println(sb);






    }
}
