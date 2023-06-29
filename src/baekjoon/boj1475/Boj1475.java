import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(System.in));
 
        String str = br.readLine();
 
        int size = str.length();
        int[] arr = new int[10];
        int temp = 0;
        int max = 0;
 
        //counting 배열을 사용하였다.
        for (int i = 0; i < size; i++) {
            temp = str.charAt(i) - '0';
            arr[temp]++;
 
        }
        //다른 숫자는 상관없지만 6,9일땐 바꿔서 사용가능하다.
        //6,9를 같은 숫자로 본다.
        int k = (arr[6] + arr[9]);
        //6,9의 합이 짝수이면 반으로 나누면 된다.
        if (k % 2 == 0) {
            arr[6] = k / 2;
            arr[9] = k / 2;
        }
        //6,9의 합이 홀수이면 반으로 나눠도 1번 더 사용해야되기 때문에 1을 더해준다.
        else {
            arr[6] = k / 2 + 1;
            arr[9] = k / 2 + 1;
        }
        //반복해서 최대값을 찾는다.
        for (int i : arr) {
            max = Math.max(max, i);
        }
        System.out.println(max);
    }
 
}
