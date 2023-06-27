import java.util.*;

public class Boj1439{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] a = s.split("");
		int zero = 0, one = 0;
		
		if(a[0].equals("0"))
			zero++;
		else
			one++;
		
		for(int i = 1; i < a.length; i++) {
			if(!a[i-1].equals(a[i])) {
				if(a[i].equals("0"))
					zero++;
				else
					one++;
			}
		}
		System.out.println(Math.min(zero, one));	
	}
}
