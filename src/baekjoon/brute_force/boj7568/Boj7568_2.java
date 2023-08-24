package baekjoon.brute_force.boj7568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj7568_2 {
    public static class Person{
        int x, y, s;
        public Person(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void setS(int s) {
            this.s = s;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj7568/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Person[] persons = new Person[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            persons[i] = new Person(x, y);
        }

        for(Person person1 : persons){
            int count = 0;
            for(Person person2 : persons){
                if(person1 == person2)  continue;
                if(person1.x < person2.x && person1.y < person2.y)  count++;
            }
            person1.setS(count + 1);
        }

        for(Person person : persons){
            sb.append(person.s).append(" ");
        }
        System.out.println(sb);

    }
}
