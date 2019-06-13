package fundamental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2558 { // A+B-2 : http://www.acmicpc.net/problem/2558

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		System.out.println(a+b);

	}

}
