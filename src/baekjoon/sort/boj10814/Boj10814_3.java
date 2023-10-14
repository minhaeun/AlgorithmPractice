package baekjoon.sort.boj10814;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj10814_3 {
    public static class Person implements Comparable<Person>{
        int num, age;
        String name;
        public Person(int num, int age, String name){
            this.num = num;
            this.age = age;
            this.name = name;
        }

        public int compareTo(Person o){
            if(this.age == o.age)   return this.num - o.num;
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/sort/boj10814/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Person[] arr = new Person[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Person(i + 1, age, name);
        }
        Arrays.sort(arr);
        for(Person person : arr){
            sb.append(person.age).append(" ").append(person.name).append("\n");
        }
        System.out.println(sb);

    }
}
