package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11654 { // 아스키 코드 : http://www.acmicpc.net/problem/11654 

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		int res = input.charAt(0);
		
		System.out.println(res);
	}

}
