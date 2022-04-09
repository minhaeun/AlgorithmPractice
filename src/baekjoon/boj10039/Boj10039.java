package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj10039 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 0;
		for(int i = 0; i < 5; i++) {
			int score = Integer.parseInt(br.readLine());
			
			if(score < 40) {
				score = 40;
			}
			
			total += score;
		}
		System.out.println(total / 5);
		
		
		
	}

}
