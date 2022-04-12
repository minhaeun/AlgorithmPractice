package SWEA.SWEA5607;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5607 {
    public static long[] fac;
    public static final int mod = 1234567891;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/SWEA/SWEA5607/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());


            fac = new long[1000001];
            fac[0] = 1;
            for (int i = 1; i < 1000001; i++) {
                fac[i] = (fac[i - 1] * i) % mod;
            }

            sb.append("#").append(tc).append(" ").append(nCr(N, R)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static long nCr(int n, int r) {
        if (r == 0)
            return 1L;
         return (fac[n] * power((fac[n - r] * fac[r]) % mod, mod - 2, mod)) % mod;
       // return (fac[n] * power(fac[r], mod - 2, mod) % mod * power(fac[n - r], mod - 2, mod)) % mod;
    }

    static long power(long x, long y, long p) {
        long res = 1L;
        x = x % p;

        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

}
