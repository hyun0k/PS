package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10039 { // 평균 점수 : http://www.acmicpc.net/problem/10039 

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int temp = 0;
		for (int i = 0; i < 5; i++) {
			temp = Integer.parseInt(br.readLine());
			if (temp < 40) {
				sum += 40;
			} else {
				sum += temp;
			}
		}
		System.out.println(sum / 5);
	}

}
