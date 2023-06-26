import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        String[] binary = {"000", "001", "010", "011", "100", "101", "110", "111"};
        for(int i = 0; i < n.length(); i++) {
            int octa = n.charAt(i) - '0';
            String bin = binary[octa];

            if(i == 0) {
                if(bin.startsWith("000")) {
                    System.out.print("0");
                }else if(bin.startsWith("00")) {
                    System.out.print(bin.charAt(2));
                }else if(bin.startsWith("0")) {
                    System.out.print(bin.charAt(1));
                    System.out.print(bin.charAt(2));
                }else {
                    System.out.print(bin);
                }

            }else {
                System.out.print(bin);
            }
        }
    }
}
